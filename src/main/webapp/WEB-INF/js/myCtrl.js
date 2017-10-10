app1.controller('EmployeeCtrl', function($scope, $http) {
	
    $http({
        method : "GET",
        url : "/HelloWorld/rest/employee/getAllEmployees"
    }).then(function mySuccess(response) {
        $scope.allEmployees = response.data;
    }, function myError(response) {
        $scope.allEmployees = "Something went wrong";
    });


    $http({
        method : "GET",
        url : "/HelloWorld/rest/employee/searchEmployee/{id}"
    }).then(function mySuccess(response) {
        $scope.employee = response.data.lastname;
    }, function myError(response) {
        $scope.employee = "Something went wrong";
    });
});

app2.controller('myCtrl', function($scope) {
    $scope.count = 0;
});