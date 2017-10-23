<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Portal</title>
<link rel="stylesheet" href="css/employee.css" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<!-- <link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
<script src="js/employee.js"></script>
</head>
<body>
	<h1>Employee Details</h1>
	<div ng-app="employeePortal" ng-controller='employeeController'>
		<form name="employeeForm" novalidate>
			<table align="center" style="width: 100%">
				<!-- <tr>
				<td>Enter ID : </td>
				<td><input type="text" ng-model="emp.id"></td>
			</tr>  -->
				<tr>
					<td>First name :</td>
					<td><input type="text" name="firstName"
						ng-model="emp.firstName" required></td>
				</tr>
				<tr>
					<td>Last name :</td>
					<td><input type="text" ng-model="emp.lastName"></td>
				</tr>
				<tr>
					<td>Designation :</td>
					<td><input type="text" ng-model="emp.desgination"
					ng-pattern="/^[a-z]" required></td>
				</tr>
				<tr>
					<td>Salary :</td>
					<td><input type="text" ng-model="emp.salary" required></td>
				</tr>
				<tr>
					<td>Date of Birth :</td>
					<td><input type="date" name="dateOfBirth" ng-model="emp.dateOfBirth"
						placeholder="click for calender view" required></td>
				</tr>
				<tr>
					<td>Self Rating :</td>
					<td><input type="text" ng-model="emp.rating" required></td>
				</tr>
				<tr>
					<td>Email Id :</td>
					<td><input type="email" name="email" ng-model="emp.emailId"
						ng-pattern="/^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/" required></td>
				</tr>
				<tr>
					<td><input type="reset" value="Reset" /></td>
					<td><input type="submit" name="submit"
						ng-click="addEmployee(emp)"
						ng-disabled="!employeeForm.email.$valid" value="submit"></td>
				</tr>
			</table>
		</form>
		<!-- <button ng-click="redirect()">Click</button> -->
		<p>
			<span ng-show="employeeForm.$submitted">Successfully submitted</span>
		</p>
		<div>
			Search Employee : <input type="text" ng-model="identity"/> <input type="button" ng-click="searchEmployee()" value="Search">
			<p>{{employee2}}</p>
		</div>
		
		<div>
		<table>
			<tr>
				<td>Enter Firstname</td>
				<td><input type="text" ng-model="search.$"/></td>
			</tr>
			<tr><td>Name</td></tr>
			<tr ng-repeat="empObj in allEmployees | filter:search">
			<td>{{empObj.firstName}}</td>
			</tr>
			</table>
		</div>
	</div>
</body>
</html>