package com.oms.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oms.models.Customer;
import com.oms.models.OrderRequest;
import com.oms.models.OrderResponse;
import com.oms.repositories.CustomerRepository;
import com.oms.service.CustomerService;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {
		
		@Autowired
		CustomerService customerService;
		
		@Autowired
		CustomerRepository customerRepo;
	

		@PostMapping( value="",consumes=MediaType.APPLICATION_JSON_VALUE)
		@Validated
		public ResponseEntity<Customer> createCustomer(@RequestBody @Valid Customer customer){
			return ResponseEntity.ok(customer);
		}
		
		@PostMapping(value = "/order",consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<OrderResponse> createOrder(@RequestBody @Valid OrderRequest orderData){
			OrderResponse orderResponse = customerService.createOrder(orderData);
			return ResponseEntity.ok(orderResponse);
		}
}
