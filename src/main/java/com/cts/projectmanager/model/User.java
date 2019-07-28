package com.cts.projectmanager.model;

import org.springframework.data.annotation.Id;

public class User extends PmBase{
	@Id
    private String id;
	private String employeeID;
	private String firstName;
	private String lastName;
	public User() {
		
	}
	public User(String id, String employeeID, String firstName, String lastName) {
		super();
		this.id = id;
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
