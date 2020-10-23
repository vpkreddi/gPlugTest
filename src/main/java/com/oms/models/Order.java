package com.oms.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

	private String id;
	private Date order_date;
	private Double order_amount;
	private Double discount_value=0.0;
	private Double discount_percentage;
	
}
