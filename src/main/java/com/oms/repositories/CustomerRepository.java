package com.oms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oms.models.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
