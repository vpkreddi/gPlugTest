package com.oms.models;

import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Validated
public class OrderRequest {
	
	public String customerId;
	@Min(1)
	public Double amount;

}
