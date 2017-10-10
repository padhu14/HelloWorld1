package com.programcreek.helloworld.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.programcreek.helloworld.model.Employee;
import com.programcreek.helloworld.service.EmployeeManager;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Log LOG = LogFactory.getLog(EmployeeController.class);
	
	@Autowired
	private EmployeeManager employeeManager;

	
	@RequestMapping(value = "/getAllEmployees",method=RequestMethod.GET
			,headers="Accept=application/json")
	public @ResponseBody ResponseEntity<List<Employee>> getAllEmployees() throws Exception {
		System.out.println("in EmployeeController");
		
		return new ResponseEntity<>(this.employeeManager.getEmployeeList(),HttpStatus.OK);
		
	}
	@RequestMapping(value = "/addEmployee",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE
			,consumes=MediaType.APPLICATION_JSON_VALUE
			,headers = "Accept=application/json")
	public @ResponseBody ResponseEntity<List<Employee>> addEmployee(@RequestBody(required=false) Employee employee) throws Exception {
		LOG.info(employee.toString());
		employeeManager.addEmployees(employee);
		System.out.println("Employee Added Successfully");
		return new ResponseEntity<>(this.employeeManager.getEmployeeList(),HttpStatus.OK);
		
	}
	
	@RequestMapping(value="searchEmployee/{identity}", method = RequestMethod.GET
			,headers="Accept=application/json")
	public @ResponseBody ResponseEntity<Employee> findCustomerById(@PathVariable("identity") String id) {
		Employee employee = employeeManager.searchEmployee(id);
		LOG.info(employee.toString());
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}