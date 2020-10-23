package com.oms.models;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
@Validated
public class Customer {

	@Id
	private String id;
	@NotEmpty
	private String name;
	@Email
	private String email;
	@Indexed(name = "mobile_index",unique = true)
	@Digits(integer = 10, fraction = 0)
	private long mobile;
	@Null
	private List<Order> orders;
	@Null
	private CustomerType type;
}
