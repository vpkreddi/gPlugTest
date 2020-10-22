package com.oms.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Customer {

	@Id
	private String id;
	private String name;
	private String email;
	@Indexed(unique = true)
	private String mobile;
	private List<Order> orders;
	private CustomerType type;
}
