package com.springbootfundamentals.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;

import com.springbootfundamentals.store.entities.Address;
import com.springbootfundamentals.store.entities.Tag;
import com.springbootfundamentals.store.entities.User;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		// ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);

		/**
		 * Examples
		 */
		// entityAnnotations();
		// oneToManyReplationships();
		// manyToManyReplationships();
	}

	public static void entityAnnotations() {

		var user = new User(1L, "name", "email", "password", null, null);
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

	public static void oneToManyReplationships() {
		// create user object using the builder pattern
		var user = User.builder()
		.name("john")
		.password("password")
		.email("john@example.com")
		.build();

		var address = Address.builder()
		.street("street")
		.city("city")
		.state("state")
		.zip("zip")
		.build();

		// custom addAddress method to abstract the connection of the objects to the user entity
		user.addAddress(address);
		System.out.println(user);
	}

	public static void manyToManyReplationships() {
		var user = User.builder()
		.name("john")
		.password("password")
		.email("john@example.com")
		.build();

		user.addTag("tag1");
		System.out.println(user);
}

}
