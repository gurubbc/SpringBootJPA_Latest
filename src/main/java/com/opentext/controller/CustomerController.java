package com.opentext.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opentext.model.Customer;
import com.opentext.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public ArrayList<Customer> fetchAllCustomers(){
		return customerService.fetchAllCustomers();
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public String addACustomer(@RequestBody Customer newCustomer) {
		System.out.println("CustomerController method is called...");
		return customerService.insertACustomer(newCustomer);
	}
	
	@RequestMapping(value = "/customers/id/{id}", method = RequestMethod.DELETE)
	public String deleteACustomer(@PathVariable("id") int custId) {
		return customerService.deleteById(custId);
	}
	
	@RequestMapping(value = "/customers/id/{id}", method = RequestMethod.PATCH)
	public String updateACustomer(@PathVariable("id") int custId, @RequestBody Customer cust) {
		return customerService.updateACustomer(custId, cust);
	}
	
}
