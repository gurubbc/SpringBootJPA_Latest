package com.opentext.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.opentext.model.Customer;
import com.opentext.model.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	// This method will return all customers
	public ArrayList<Customer> fetchAllCustomers() {
		ArrayList<Customer> customers = new ArrayList<>();
		// findAll() method internally generates SELECT * sql query
		customerRepository.findAll().forEach(customer -> {
			customers.add(customer);
		});
		return customers;
	}
	
	public String insertACustomer(Customer cust) {
	Customer newlyAddedCustomer=customerRepository.save(cust); // This generates INSERT INTO  sql behind the scene
	if (newlyAddedCustomer != null) {
        return "Customer added successfully with ID: " + newlyAddedCustomer.getCustomerId();
    } else {
        return "Failed to add customer, seems some error occurred. Please try again later.";
    }
	}
	
	public String deleteById(int custId) {
		String msg="";
		if (customerRepository.existsById(custId)) {
			customerRepository.deleteById(custId); // This generates DELETE FROM sql behind the scene
			msg= "Customer with ID " + custId + " deleted successfully.";
		} else {
			msg= "Failed to delete customer with ID " + custId + ". Please try again later.";
		}
		return msg;
	}
	
	public String updateACustomer(int custId, Customer cust) {
		// check if customer exists
		Customer existingCustomer=customerRepository.findById(custId).orElse(null);
		// if customer is present
		if (existingCustomer!=null) {
			// check what are the values the the client is sending to us
			if (cust.getFirstName()!=null) {
				existingCustomer.setFirstName(cust.getFirstName()); // this will generate UPDATE sql behind the scene
			}
			if (cust.getLastName()!=null) {
				existingCustomer.setLastName(cust.getLastName()); // this will generate UPDATE sql behind the scene
			}
			if (cust.getPhoneNumber()!=0) {
				existingCustomer.setPhoneNumber(cust.getPhoneNumber()); // this will generate UPDATE sql behind the scene
			}
			if (cust.getEmailId() != null) {
				existingCustomer.setEmailId(cust.getEmailId()); // this will generate UPDATE sql behind the scene
			}
			
		} else 
		{
			return "Customer with ID " + custId + " not found. Please check the ID and try again.";
		}
		Customer c=customerRepository.save(existingCustomer); // This generates UPDATE sql behind the scene.
		if (c != null) {
			return "Customer with ID " + custId + " updated successfully.";
		} else {
			return "Failed to update customer with ID " + custId + ". Please try again later.";
		}
		
	}
}

