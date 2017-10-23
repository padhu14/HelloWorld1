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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.programcreek.helloworld.model.Employee;
import com.programcreek.helloworld.service.EmployeeManager;
import com.programcreek.helloworld.service.EmployeeManager1;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Log LOG = LogFactory.getLog(EmployeeController.class);
	
	@Autowired
	private EmployeeManager employeeManager;
	
	@Autowired
	private EmployeeManager1 empManager;

	
	@RequestMapping(value = "/getAllEmployees",method=RequestMethod.GET
			,headers="Accept=application/json")
	public @ResponseBody ResponseEntity<List<Employee>> getAllEmployees() throws Exception {
		System.out.println("in EmployeeController");
		
		return new ResponseEntity<>(this.employeeManager.getEmployeeList(),HttpStatus.OK);
		
	}
	@RequestMapping(value = "/addEmployee",method=RequestMethod.POST,
			headers = "Accept=application/json")
	public @ResponseBody List<Employee> addEmployee(@RequestBody Employee employee) throws Exception {
		LOG.info(employee.toString());
		employeeManager.addEmployees(employee);
		System.out.println("Employee Added Successfully");
		return (this.employeeManager.getEmployeeList());
		
	}
	
	@RequestMapping(value="/searchEmployee/{identity}", method = RequestMethod.GET
			,headers="Accept=application/json")
	public @ResponseBody ResponseEntity<Employee> findCustomerById(@PathVariable("identity") String id) {
		Employee employee = employeeManager.searchEmployee(id);
		LOG.info(employee.toString());
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/employee",method=RequestMethod.POST
			,headers="Accept=application/json")
	public @ResponseBody ResponseEntity<Employee> createEmployee(@RequestBody(required=false) Employee employee){
		LOG.info(employee.toString());
		empManager.create(employee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(value="/findEmployee/{identity}", method = RequestMethod.GET
			,headers="Accept=application/json")
	public @ResponseBody ResponseEntity<Employee> findEmployeeById(@PathVariable("identity") Long id) {
		Employee employee = empManager.readById(id);
		LOG.info(employee.toString());
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	

	@RequestMapping(value="/employee",method=RequestMethod.PUT
			,headers="Accept=application/json")
	public @ResponseBody ResponseEntity<Employee> updateEmployee(@RequestBody(required=false) Employee employee){
		LOG.info(employee.toString());
		empManager.update(employee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(value="/employee",method=RequestMethod.DELETE
			,headers="Accept=application/json")
	public @ResponseBody ResponseEntity<Employee> deleteEmployee(@RequestParam(required=false) String id){
		
		empManager.deleteById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping(value="/searchEmployeeName/{name}", method = RequestMethod.GET
			,headers="Accept=application/json")
	public @ResponseBody ResponseEntity<List<Employee>> findEmployeeByName(@PathVariable("name") String name) {
		List<Employee> employees = empManager.findByName(name);
		LOG.info(employees.toString());
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllEmployeesfromDB", method = RequestMethod.GET
			,headers="Accept=application/json")
	public @ResponseBody ResponseEntity<List<Employee>> getAllEmployeesfromDB() {
		List<Employee> employees = empManager.getAllEmployees();
		
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
}