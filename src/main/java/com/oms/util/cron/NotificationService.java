package com.oms.util.cron;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.oms.models.CustomerType;
import com.oms.repositories.CustomerRepository;

@Service
@EnableAsync
public class NotificationService {

	@Autowired
	CustomerRepository customerRepo;

	@Scheduled(cron = "${orders.email.alert.cron}")
	@Async("threadPoolTaskExecutor")
	public void sendEmail() {
		System.out.println("Running cron job at ------------------------:"+ new Date());
		customerRepo.findAll().stream().filter(customer -> {
			if(customer.getOrders()==null || customer.getOrders().size()==0) {
				return false;
			}else if( 10-customer.getOrders().size() >0 &&  10-customer.getOrders().size()<3) {
				return true;
			}else if( 20-customer.getOrders().size() >0 &&  20-customer.getOrders().size()<3) {
				return true;
			} return false;
		}).forEach(customer ->{
			if(customer.getType().equals(CustomerType.REGULAR)) {
				int count = 10-customer.getOrders().size();
				System.out.println("sending email to Regular customer: please do "+count+" more orders to become GOLD CUSTOMER");
			} else if(customer.getType().equals(CustomerType.GOLD)) {
				int count = 20-customer.getOrders().size();
				System.out.println("sending email to gold customer: please do "+count+" more orders to become PLATINUM CUSTOMER");
			}
		});
	}
}
