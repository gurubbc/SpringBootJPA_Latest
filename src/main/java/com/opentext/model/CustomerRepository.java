package com.opentext.model;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	// No need to define any methods here, just leave it blank
	// just for comparison purpose, this can be thought of as the DAO class
}
