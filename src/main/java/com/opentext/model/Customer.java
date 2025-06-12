package com.opentext.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
// by adding this annotation, you are saying that there will be a 
// corresponding database table with the same name as the class
public class Customer {
	@Id
	private int customerId; // CUSTOMER_ID
	private String firstName; // FIRST_NAME
	private String lastName; // LAST_NAME
	private String emailId; // EMAIL_ID
	private long phoneNumber; // PHONE_NUMBER
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerId, String firstName, String lastName, String emailId, long phoneNumber) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
