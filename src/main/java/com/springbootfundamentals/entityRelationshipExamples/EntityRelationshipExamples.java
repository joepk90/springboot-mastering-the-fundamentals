package com.springbootfundamentals.entityRelationshipExamples;
import java.util.HashSet;
import com.springbootfundamentals.store.entities.Address;
import com.springbootfundamentals.store.entities.Product;
import com.springbootfundamentals.store.entities.Profile;
import com.springbootfundamentals.store.entities.User;

public class EntityRelationshipExamples {

	public static void main(String[] args) {
		/**
		 * Examples
		 */
		// entityAnnotations();
		// oneToManyReplationships();
		// manyToManyReplationships();
		// oneToOneReplationships();
	}

	public static void entityAnnotations() {

		var faverouteProducts = new HashSet<Product>();
		var user = new User(1L, "name", "email", "password", null, null, null, faverouteProducts);
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

	public static void oneToOneReplationships() {
		var user = User.builder()
		.name("john")
		.password("password")
		.email("john@example.com")
		.build();

		var profile = Profile.builder()
			.bio("bio")
			.build();

		// user.setProfile(profile); // profile field has been disabled on User class to prevent unnessecary eager loading
		profile.setUser(user);
		System.out.println(user);
	}

}
