package com.springbootfundamentals.dependancyDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.springbootfundamentals.dependancyDemo.HeavyResource;
import com.springbootfundamentals.dependancyDemo.NotificationManager;
import com.springbootfundamentals.dependancyDemo.OrderService;
import com.springbootfundamentals.dependancyDemo.User;
import com.springbootfundamentals.dependancyDemo.UserService;

/**
 * To Enable this SpringBoot Application, enable the @SpringBootApplication annotation, and
 * remove any other @SpringBootApplication annotations elsewhere in the project
 */

// @SpringBootApplication
public class DependancyDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependancyDemoApplication.class, args);

	}



	
	/**
	 * COURSE DOCUMENTATION
	 * 
	 * The below methods won't be run.
	 * They are here to represent different sections of the course.
	 * 
	 * To run one of them, update the name of the method to main.
	 *
	 */

	// method won't be run
	public static void dependancyInjection(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependancyDemoApplication.class, args);

		var NotificationManager = context.getBean(NotificationManager.class);
		NotificationManager.sendNotification("This is a test");	
	}

	// method won't be run
	public static void resourceTypes(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependancyDemoApplication.class, args);

		var OrderService = context.getBean(OrderService.class);
		OrderService.placeOrder();

		// when the OrderService is set to use the prototype scope,
		// this will instantiate a second instance of the OrderService
		var OrderService2 = context.getBean(OrderService.class);
		OrderService2.placeOrder();
	}

	// method won't be run
	public static void lazyInitialisation(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependancyDemoApplication.class, args);

		// by applying the @Lazy annotation to the class, and requesting the resource here
		// the resource is created later, when it is actually needed
		context.getBean(HeavyResource.class);
	}

	// method won't be run
	public static void lifecycleHooks(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependancyDemoApplication.class, args);

		var OrderService = context.getBean(OrderService.class);
		OrderService.placeOrder();

		// kill the application by closing the context (to trigger the PreDestroy lifecycle hook)
		// note:
		// - this causes an error: Socket accept failed
		// - so does mosh's code at the same commit (vscode/jenv)
		context.close();
	}

		// method won't be run
		public static void userRegistrationService(String[] args) {
			ConfigurableApplicationContext context = SpringApplication.run(DependancyDemoApplication.class, args);

			UserService userService = context.getBean(UserService.class);
			userService.registerUser(new User(1l, "john@gmail.com", "12345", "john"));
			// userService.registerUser(new User(1l, "john@gmail.com", "12345", "john"));
			userService.registerUser(new User(1l, "ben@gmail.com", "12345", "ben"));
		}

}
