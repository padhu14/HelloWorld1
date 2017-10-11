app1.controller('EmployeeCtrl', function($scope, $http) {

	$http({
		method : "GET",
		url : "/HelloWorld/rest/employee/getAllEmployees"
	}).then(function mySuccess(response) {
		$scope.today = new Date();
		$scope.allEmployees = response.data;
	}, function myError(response) {
		$scope.allEmployees = "Something went wrong";
	});

	$scope.searchEmployee = function() {
		$http({
			method : "GET",
			url : '/HelloWorld/rest/employee/searchEmployee/' + $scope._id
		}).then(function mySuccess(response) {
			$scope.employee = response.data;
		}, function myError(response) {
			$scope.employee = "Something went wrong";
		});
	}
	$scope.addEmployee = function(id,lastName,firstName) {
		var reqdata = {
			id : id,
			lastName : lastName,
			firstName : firstName
		};
		$http({
			method : "POST",
			url : '/HelloWorld/rest/employee/addEmployee',
			data :  reqdata,
			headers: {'Content-Type': 'application/json'}
		}).then(function mySuccess(response) {
			$scope.employee = response.data;
		}, function myError(response) {
			$scope.employee = "Something went wrong";
		});
	}
});


