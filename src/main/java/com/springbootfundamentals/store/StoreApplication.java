package com.springbootfundamentals.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;

import com.springbootfundamentals.store.entities.User;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		// ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);

		/**
		 * Examples
		 */
		// entityAnnotations();
	}

	public static void entityAnnotations() {
		var user = new User(1L, "name", "email", "password");
		user.setName("john");
		user.setEmail("john@example.com");
		user.setPassword("password");

		// create user object using the builder pattern
		var buildUser = User.builder()
		.name("john")
		.password("password")
		.email("john@example.com")
		.build();
	}

}
