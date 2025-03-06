package com.springbootfundamentals.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		// SpringApplication.run(StoreApplication.class, args);
		var OrderService = new OrderService();
		OrderService.setPaymentService(new PaypalPaymentService()); // setter injectin should only be used for optioal dependancies
		OrderService.placeOrder();
	}

}
