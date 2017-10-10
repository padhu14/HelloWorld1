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



		Enter ID <input type="text" ng-model="_id" />
		<button ng-click="searchEmployee()">Click Me!</button>
		<h3 ng-disabled = "_id.$untouched">{{employee | json : 12}}</h3>
		
		<form name="insertvalue">
		ID : <input type="text" ng-model="id" /><br>
		First Name : <input type="text" ng-model="firstName" /><br>
		Last Name : <input type="text" ng-model="lastName" /><br>
		<button value="submit" ng-click="addEmployee(id,firstName,lastName)">Submit</button>
		</form>
	</div>


	<!-- <div ng-app="myApp" ng-controller="myCtrl">
		<h1 ng-mousemove="count = count + 1" align="center">Mouse over
			me!</h1>

		<h2>{{ count }}</h2>

	</div> -->

	<!-- <h2>Validation Example</h2>

	<form ng-app="myApp" ng-controller="validateCtrl" name="myForm"
		novalidate>

		<p>
			Username:<br> <input type="text" name="user" ng-model="user"
				required> <span style="color: red"
				ng-show="myForm.user.$dirty && myForm.user.$invalid"> <span
				ng-show="myForm.user.$error.required">Username is required.</span>
			</span>
		</p>

		<p>
			Email:<br> <input type="email" name="email" ng-model="email"
				required> <span style="color: red"
				ng-show="myForm.email.$dirty && myForm.email.$invalid"> <span
				ng-show="myForm.email.$error.required">Email is required.</span> <span
				ng-show="myForm.email.$error.email">Invalid email address.</span>
			</span>
		</p>

		<p>
			<input type="submit" ng-model="submit"
				ng-disabled="myForm.user.$dirty && myForm.user.$invalid ||
  myForm.email.$dirty && myForm.email.$invalid">
		</p>
		<input type="button" value="Reset" ng-click="reset()"/>
	<h3 ng-disabled="submit.$invalid">{{myForm.user}} - {{myForm.email}}</h3>
	</form> -->

</body>
</html>