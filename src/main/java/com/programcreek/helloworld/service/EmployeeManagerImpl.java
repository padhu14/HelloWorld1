package com.programcreek.helloworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programcreek.helloworld.dao.EmployeeDAO;
import com.programcreek.helloworld.model.Employee;

@Service("empManager")
public class EmployeeManagerImpl implements EmployeeManager1 {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private CounterService counterService; 
	
	@Override
	public void create(Employee e) {
		e.setId(String.valueOf(counterService.getNextSequence("Employee")));
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

	@Override
	public List<Employee> findByName(String name) {
		return employeeDAO.findByKey(name);
	}

}
