package com.springbootfundamentals.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		var OrderService = context.getBean(OrderService.class);
		OrderService.placeOrder();

		var NotificationManager = context.getBean(NotificationManager.class);
		NotificationManager.sendNotification("This is a test");	
		
		// by applying the @Lazy annotation to the class, and requesting the resource here
		// the resource is created later, when it is actually needed
		context.getBean(HeavyResource.class);
	}

}
