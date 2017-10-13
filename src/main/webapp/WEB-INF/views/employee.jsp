<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Portal</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	 <link rel="stylesheet" href="css/employee.css">
	 <script src="js/employee.js"></script>
</head>
<body>
	<form name="employeeForm" ng-app='employee' ng-controller='employeeController'>
		<table align="center" style="width:100%">
			<!-- <tr>
				<td>Enter ID : </td>
				<td><input type="text" ng-model="emp.id"></td>
			</tr> -->
			<tr>
				<td>First name : </td>
				<td><input type="text" name="firstName" ng-model="emp.firstName" required></td>
			</tr>
			<tr>
				<td>Last name : </td>
				<td><input type="text" ng-model="emp.lastName"></td>
			</tr>
			<tr>
				<td>Designation : </td>
				<td><input type="text" ng-model="emp.desgination" required></td>
			</tr>
			<tr>
				<td>Salary : </td>
				<td><input type="text" ng-model="emp.salary" required></td>
			</tr>
			<tr>
				<td>Date of Birth : </td>
				<td><input type="date" ng-model="emp.dateOfBirth" placeholder="yyyy-MM-dd"
					required></td>
			</tr>
			<tr>
				<td>Self Rating : </td>
				<td><input type="text" ng-model="emp.rating" required></td>
			</tr>
			<tr>
				<td>Email Id : </td>
				<td><input type="text" name="emailId" ng-model="emp.emailId" required></td>
			</tr>
			<tr>
				<td><input type="button" ng-click="reset()" value="Reset" /> </td>
				<td><input type="submit" ng-click="addEmployee(emp)" ng-disabled="employeeForm.emailId.$invalid"></td>
			</tr>
		</table>
		{{employee | json}}
	</form>
</body>
</html>