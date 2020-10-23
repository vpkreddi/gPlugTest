package com.oms.models;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {
	
	private String OrderId;
	@NotNull
	private Double discount_value=0.0;
}
