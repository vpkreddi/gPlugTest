package com.oms.util.cron;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
@EnableAsync
public class NotificationService {

	@Scheduled(cron = "${orders.email.alert.cron}")
	@Async("threadPoolTaskExecutor")
	public void sendEmail() {
		
	}
}
