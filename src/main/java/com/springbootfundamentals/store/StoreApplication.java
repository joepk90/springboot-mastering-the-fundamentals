package com.springbootfundamentals.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		
		var OrderService = context.getBean(OrderService.class);
		OrderService.placeOrder();

		// kill the application by closing the context (to trigger the PreDestroy lifecycle hook)
		// note:
		// - this causes an error: Socket accept failed
		// - so does mosh's code at the same commit (vscode/jenv)
		// context.close();
		

		// when the OrderService is set to use the prototype scope,
		// this will instantiate a second instance of the OrderService
		// var OrderService2 = context.getBean(OrderService.class);
		// OrderService2.placeOrder();

		var NotificationManager = context.getBean(NotificationManager.class);
		NotificationManager.sendNotification("This is a test");	
		
		// by applying the @Lazy annotation to the class, and requesting the resource here
		// the resource is created later, when it is actually needed
		context.getBean(HeavyResource.class);

		System.out.println("=== USER SERVICE ===");

		UserService userService = context.getBean(UserService.class);
		userService.registerUser(new User(1l, "john@gmail.com", "12345", "john"));
		// userService.registerUser(new User(1l, "john@gmail.com", "12345", "john"));
		userService.registerUser(new User(1l, "ben@gmail.com", "12345", "ben"));
	}

}
