package com.oms.controller;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.models.Customer;

@RestController("/customer")
public class CustomerController {

		@PostMapping( consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
			return ResponseEntity.ok(customer);
		}
}
