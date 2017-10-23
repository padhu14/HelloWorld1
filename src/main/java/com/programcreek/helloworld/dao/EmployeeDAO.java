package com.programcreek.helloworld.dao;

import java.util.List;

import com.programcreek.helloworld.model.Employee;

public interface EmployeeDAO {
	public void create(Employee e);

	public Employee readById(Long id);

	public void update(Employee e);

	public int deleteById(String id);

	public List<Employee> findByKey(String key);

	public List<Employee> getAllEmployees();
}
