package com.programcreek.helloworld.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
import com.programcreek.helloworld.model.Employee;

@Repository("employeeDAO")
public class EmployeeDAOimpl implements EmployeeDAO {
	
	@Autowired
	private MongoOperations mongoOps;
	
	private static final String EMPLOYEE_COLLECTION = "Employee";
	
	/*public EmployeeDAOimpl(MongoOperations mongoOps){
		this.mongoOps = mongoOps;
	}*/
	
	@Override
	public void create(Employee e) {
		this.mongoOps.insert(e, EMPLOYEE_COLLECTION);

	}

	@Override
	public Employee readById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoOps.findOne(query, Employee.class, EMPLOYEE_COLLECTION);
	}

	@Override
	public void update(Employee e) {
		this.mongoOps.save(e, EMPLOYEE_COLLECTION);

	}

	@Override
	public int deleteById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		WriteResult result = this.mongoOps.remove(query, Employee.class, EMPLOYEE_COLLECTION);
		Employee emp = (Employee) result.getUpsertedId();
		return result.getN();
	}
	
	public void setMongoOps(MongoOperations mongoOps) {
        this.mongoOps = mongoOps;
    }
	
	public List<Employee> findByKey(String key) {
		Query query = new Query(Criteria.where("firstName").is(key));
        return mongoOps.find(query, Employee.class);
    }
}
