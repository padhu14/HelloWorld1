<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC -HelloWorld</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	
<style>
table, th, td {
	border: 1px solid grey;
	border-collapse: collapse;
	padding: 5px;
}

table tr:nth-child(odd) {
	background-color: #f1f1f1;
}

table tr:nth-child(even) {
	background-color: #ffffff;
}
input.ng-invalid {
    background-color: pink;
}
input.ng-valid {
    background-color: white;
}
</style>
<script src="js/myApp.js"></script>
<script src="js/myCtrl.js"></script>

</head>
<body>

	<center>
		<h2>Hello World</h2>
		<h2>${message}${name}</h2>
	</center>
	<div ng-app="empApp" ng-controller="EmployeeCtrl">
		<table>
			<tr ng-repeat="x in allEmployees | orderBy : 'lastName'">
				<td>{{ x.id }}</td>
				<td>{{ x.firstName }}</td>
				<td>{{ x.lastName }}</td>
			</tr>
		</table>
		<select ng-model="selectedEmp">
			<option ng-repeat="x in allEmployees" value="{{x.firstName}}">{{x.lastName}}</option>
		</select>

		<h1>You selected: {{selectedEmp}}</h1>
		<p ng-show="true">I am visible.</p>

		<p ng-show="false">I am not visible.</p>
		<p>Date = {{ today | date : "dd.MM.y" }}</p>



		Enter ID <input type="text" ng-model="_id" />
		<button ng-click="searchEmployee()">Click Me!</button>
		<h3 ng-disabled = "_id.$untouched">{{employee | json : 12}}</h3>
		
		<form name="insertvalue">
		<!-- ID : <input type="text" ng-model="id" name="id" required/><br> -->
		First Name : <input type="text" ng-model="firstName" name="firstName" required/><br>
		Last Name : <input type="text" ng-model="lastName" name="lastName" required/><br>
		<input type="submit" value="Submit" ng-click="addEmployee(id,firstName,lastName)" 
		ng-disabled="insertvalue.id.$invalid ||
		insertvalue.firstName.$invalid ||
		 insertvalue.lastName.$invalid"/>
		<span ng-show="insertvalue.$submitted">Form submitted successfully</span>
		
		</form>
	</div>



	

</body>
</html>