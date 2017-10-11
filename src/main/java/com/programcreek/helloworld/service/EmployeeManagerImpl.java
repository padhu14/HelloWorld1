package com.programcreek.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programcreek.helloworld.dao.EmployeeDAO;
import com.programcreek.helloworld.model.Employee;

@Service("empManager")
public class EmployeeManagerImpl implements EmployeeManager1 {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public void create(Employee e) {
		employeeDAO.create(e);
	}

	@Override
	public Employee readById(String id) {
		return employeeDAO.readById(id);
	}

	@Override
	public void update(Employee e) {
		employeeDAO.update(e);

	}

	@Override
	public int deleteById(String id) {
		return employeeDAO.deleteById(id);
	}

}
