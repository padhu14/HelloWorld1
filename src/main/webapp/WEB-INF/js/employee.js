employee.controller('employeeController', function($scope, $http) {
	$scope.list = {};
	$scope.reset = function() {
		$scope.list = angular.copy($scope.emp);
	};
	$scope.reset();
	$scope.addEmployee = function(emp) {
	$http({
		method : "POST",
		url : "/HelloWorld/rest/employee/employee",
		data : {
			 lastName : emp.lastName,
			 firstName : emp.firstName,
			 desgination : emp.desgination,
			 salary : emp.salary,
			 dateOfBirth : emp.dateOfBirth,
			 rating : emp.rating,
			 emailId : emp.emailId
		}
	}).then(function mySuccess(response) {
		$scope.employee = response.data;
	}, function myError(response) {
		$scope.employee = "Sorry, Something went wrong";
	});
	}
});