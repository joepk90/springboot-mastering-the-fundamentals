package com.springbootfundamentals.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.context.ConfigurableApplicationContext;

import com.springbootfundamentals.store.repositories.ProductRepository;
import com.springbootfundamentals.store.repositories.ProfileRepository;
import com.springbootfundamentals.store.repositories.UserRepository;

import jakarta.transaction.Transactional;

import com.springbootfundamentals.store.entities.Address;
import com.springbootfundamentals.store.entities.Category;
import com.springbootfundamentals.store.entities.Product;
import com.springbootfundamentals.store.entities.Profile;
import com.springbootfundamentals.store.entities.Tag;
import com.springbootfundamentals.store.entities.User;


/**
 * custom class used seeding the database
 */

public class DatabaseSeeder {

    private final ConfigurableApplicationContext context;

	public DatabaseSeeder(ConfigurableApplicationContext context) {
		this.context = context;
	}

	@Transactional
	public void createUser() {

		var userRepository = context.getBean(UserRepository.class);
		var profileRepository = context.getBean(ProfileRepository.class);
	
		// User -> Tags ManyToMany relation requiried cascade = { CascadeType.PERSIST } added to User class
		var tag = new Tag("tag2");
		var tags = new HashSet<Tag>();
		tags.add(tag);

		var address = Address.builder()
            .street("street")
            .state("state")
            .city("city")
            .zip("zip")
            .build();

		var user = User.builder()
            .name("John Doe")
            .email("john.doe18@example.com") // must be a unique email!
            .password("password")
            .build();
		
		// user.addTag("tag2");
		user.setTags(tags);
		user.addAddress(address);

		// User -> Profile OneToOne relation might require cascade = { CascadeType.PERSIST } added to User class
		var profile = Profile.builder()
			.bio("bio")
			.dateOfBirth(LocalDate.of(1990, 1, 1))
			.build();

			profile.setUser(user);

		profileRepository.save(profile);
		userRepository.save(user);
	}

	@Transactional
	public void createProduct() {
		var productRepository = context.getBean(ProductRepository.class);
		var category = new Category("Category 2");

        var product = Product.builder()
        .name("Product 2")
        .description("Description 2")
        .price(BigDecimal.valueOf(10.99))
        .category(category)
        .build();

        productRepository.save(product);
	}
}
