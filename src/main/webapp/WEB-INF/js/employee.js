angular.module('employeePortal', []).controller(
		'employeeController',
		function($scope, $http) {
			$scope.init =function() { $http({
					method : "GET",
					url : "/HelloWorld/rest/employee/getAllEmployeesfromDB"
			}).then(function mySuccess(response) {
				$scope.allEmployees = response.data;
			}, function myError(response) {
				$scope.allEmployees = "Sorry, cannot fetch Something went wrong";
			});
			}
			$scope.addEmployee = function(emp) {
				var empdata = {
					lastName : (emp.lastName == null) ? " " : emp.lastName,
					firstName : emp.firstName,
					desgination : emp.desgination,
					salary : emp.salary,
					dateOfBirth : emp.dateOfBirth,
					rating : emp.rating,
					emailId : emp.emailId
				}
				$http({
					method : "POST",
					url : "/HelloWorld/rest/employee/employee",
					data : JSON.stringify(empdata)
				}).then(function mySuccess(response) {
					$scope.allEmployees.push(response.data);
				}, function myError(response) {
					$scope.employee1 = "Sorry, Something went wrong";
				});
			}
			$scope.redirect = function() {
				window.location = "";
			}
			$scope.searchEmployee = function() {
				$http(
						{
							method : "GET",
							url : "/HelloWorld/rest/employee/findEmployee/"
									+ $scope.identity,
						}).then(function mySuccess(response) {
					$scope.employee2 = response.data;
				}, function myError(response) {
					$scope.employee2 = "Sorry, Something went wrong";
				});
			}
			$scope.deletePeople =  function(id) {
				$http(
						{
							method : "DELETE",
							url : "/HelloWorld/rest/employee/employee?id="+id,
						}).then(function mySuccess(response) {
							$scope.allEmployees = response.data;
				}, function myError(response) {
					$scope.employee2 = "Sorry, Something went wrong";
				});
			}
		});