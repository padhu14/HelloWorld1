package com.programcreek.helloworld.service;

import java.util.List;

import com.programcreek.helloworld.model.Employee;

public interface EmployeeManager1 {
	public void create(Employee e);

	public Employee readById(String id);

	public void update(Employee e);

	public int deleteById(String id);
	
	public List<Employee> findByName(String name);
}
