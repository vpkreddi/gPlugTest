package com.oms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.models.OrderResponse;
import com.oms.repositories.CustomerRepository;
import com.oms.models.Customer;
import com.oms.models.CustomerType;
import com.oms.models.Order;
import com.oms.models.OrderRequest;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	public OrderResponse createOrder(OrderRequest orderData) throws Exception {
		Optional<Customer> customer = customerRepo.findById(orderData.getCustomerId());
		OrderResponse orderRes = new OrderResponse();
		if (customer.isEmpty()) {
			throw new Exception("some thing wrong");
		} else {
			CustomerType type = customer.get().getType();
			checkAndUpdateCustomerType(customer.get());
			Order order = new Order();
			order.setId("OD" + genUniqueOrderId());
			order.setOrder_amount(orderData.getAmount());
			order.setOrder_date(new Date());

			if (type.equals(CustomerType.GOLD)) {
				order.setDiscount_percentage(10.00);
				order.setDiscount_value((orderData.getAmount() * 10) / 100);
			} else if (type.equals(CustomerType.PLATINUM)) {
				order.setDiscount_percentage(20.00);
				order.setDiscount_value((orderData.getAmount() * 20) / 100);
			}
			if (customer.get().getOrders() != null) {
				List<Order> orderList = customer.get().getOrders();
				orderList.add(order);
				customer.get().setOrders(orderList);

			} else {
				List<Order> orderList = new ArrayList<>(0);
				orderList.add(order);
				customer.get().setOrders(orderList);
			}

			customerRepo.save(customer.get());
			orderRes.setOrderId(order.getId());
			orderRes.setDiscount_value(order.getDiscount_value());
		}
		return orderRes;
	}

	private synchronized void checkAndUpdateCustomerType(Customer customer) {
		if(customer.getOrders()==null || customer.getOrders().size()+1<10) {
			
		}else if(customer.getOrders().size()+1==10) {
			customer.setType(CustomerType.GOLD);
		}else if(customer.getOrders().size()+1==20) {
			customer.setType(CustomerType.PLATINUM);
		}
	}

	public Customer save(@Valid Customer customer) {
		customer.setType(CustomerType.REGULAR);
		return customerRepo.save(customer);
	}

	private String genUniqueOrderId() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(9);
		for (int i = 0; i < 9; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

}
