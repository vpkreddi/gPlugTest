package com.oms.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

	private Long id;
	private Date order_date;
	private Double discount_value;
	private Double discount_percentage;
	
}
