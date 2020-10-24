package com.oms.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.oms.models.Customer;
import com.oms.models.CustomerType;
import com.oms.models.Order;
import com.oms.models.OrderRequest;
import com.oms.repositories.CustomerRepository;

@ExtendWith(SpringExtension.class)
public class CustomerServiceTestMockito {

	@Autowired
	CustomerService customerService;

	@MockBean
	CustomerRepository customerRepo;

	@TestConfiguration
	static class CustomerServiceTestMockitoSetup {

		@Bean
		public CustomerService CustomerService() {
			return new CustomerService();
		}
	}

	@Test
	public void customerSaveTest() {
		Customer customer = new Customer();
		customer.setEmail("someemail@xyz.com");
		customer.setMobile(1234567890);
		customer.setName("xyz");

		Customer customerDb = new Customer();
		customerDb.setId("ididi");
		when(customerRepo.save(customer)).thenReturn(customerDb);

		assertNotNull(customerService.save(customer).getId());
	}

	@Test
	public void createOrderTest() throws Exception {
		
		Customer customer = new Customer();
		customer.setEmail("someemail@xyz.com");
		customer.setMobile(1234567890);
		customer.setName("xyz");

		Customer customerDb = new Customer();
		customerDb.setId("ididi");
		
		OrderRequest orderData = new OrderRequest();
		orderData.setCustomerId(customerDb.getId());
		orderData.setAmount(2400.00);
	
		Order order = new Order();
		order.setId("ddd");order.setOrder_amount(orderData.getAmount());
		List<Order> orders = new ArrayList<>(0);orders.add(order);
		customerDb.setOrders(orders);customerDb.setType(CustomerType.REGULAR);
		when(customerRepo.findById(customerDb.getId())).thenReturn(Optional.of(customerDb));
		when(customerRepo.save(customer)).thenReturn(customerDb);
		
		assertNotNull(customerService.createOrder(orderData).getOrderId());
	}
}
