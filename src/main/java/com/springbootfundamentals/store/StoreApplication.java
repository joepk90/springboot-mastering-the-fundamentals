package com.springbootfundamentals.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
// import com.springbootfundamentals.utils.DatabaseSeeder;
import com.springbootfundamentals.repositoryExamples.RepositoryExamples;



@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);

		var repositoryExamples = new RepositoryExamples(context);
		repositoryExamples.main();

		// new DatabaseSeeder(context).createUser();
	}
}
