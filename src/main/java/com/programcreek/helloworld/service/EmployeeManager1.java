package com.programcreek.helloworld.service;

import java.util.List;

import com.programcreek.helloworld.model.Employee;

public interface EmployeeManager1 {
	public void create(Employee e);

	public Employee readById(Long id);

	public void update(Employee e);

	public int deleteById(String id);
	
	public List<Employee> findByName(String name);
	
	public List<Employee> getAllEmployees();

	public void resetCounter(String dbIdReset);
}
