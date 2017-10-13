package com.programcreek.helloworld.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.programcreek.helloworld.model.Employee;

@Service("employeeManager")
public class EmployeeManager {
	private static List<Employee> employeeList;

	public EmployeeManager() {
		employeeList = new ArrayList<>();
		employeeList.add(new Employee("1","Mike", "Smith"));
		employeeList.add(new Employee("2","John", "Taylor"));
		employeeList.add(new Employee("3","Dave", "Wilson"));
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	
	public void addEmployees(Employee employee){
		employeeList.add(employee);
	}
	
	public Employee searchEmployee(String id){
		List<Employee> emplist=employeeList.stream().filter(emp -> emp.getId().equalsIgnoreCase(id))
					.collect(Collectors.toCollection(ArrayList::new));
		Employee emp = emplist.get(0);
		return emp;
	}
	
}