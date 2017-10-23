package com.programcreek.helloworld.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="Employee")
@JsonFormat
public class Employee {
	
	@Id
	@Indexed(unique=true)
	private String id;
	private String lastName;
	private String firstName;
	private String desgination;
	private Long salary;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dateOfBirth;
	private int rating;
	private String emailId;

	public Employee(String id,String lastName, String firstName) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	
	public Employee(String lastName, String firstName, String desgination, Long salary, Date dateOfBirth,
			int rating, String emailId) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.desgination = desgination;
		this.salary = salary;
		this.dateOfBirth = dateOfBirth;
		this.rating = rating;
		this.emailId = emailId;
	}


	public Employee() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDesgination() {
		return desgination;
	}

	public void setDesgination(String desgination) {
		this.desgination = desgination;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", desgination="
				+ desgination + ", salary=" + salary + ", dateOfBirth=" + dateOfBirth + ", rating=" + rating + "]";
	}
	
	
}