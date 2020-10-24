package com.oms.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.oms.models.Customer;

//@SpringBootTest  -- uncomment when mongodb is up and running for integration test
public class CustomerServiceTest {
	
	@Autowired
	CustomerService customerService;
	
	//@Test -- uncomment when mongodb is up and running for integration test
	public void customerSaveTest() {
		Customer customer = new Customer();
		customer.setEmail("someemail@xyz.com");
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		customer.setMobile(number);
		customer.setName("xyz");
		Customer customerDb = customerService.save(customer);
		assertNotNull(customerDb.getId());
		
	}
}
