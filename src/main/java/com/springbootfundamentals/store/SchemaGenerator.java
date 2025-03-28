package com.springbootfundamentals.store;
import java.util.EnumSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Custom code used to generate migrations - this code was not in the Springboot course.
 * 
 * This code uses allows us to use the Model first approach without the JPABuddy IntelliJ extension
 * It compares the Entity against the database Schema, and generates a migration file with the relevant changes to syncronise them.
 * 
 * Because the oriignal sql migration files were created before setting up the entities, there are a lot of differences. But this
 * serves as an example of it working...
 * 
 * 
 * Profile: schema-genarator
 * This component will only be run of the profile is set to schema-genarator
 * In the Make file, we set the springboot profile to schema-generator for the db-migration-generate command;
 * - Dspring-boot.run.profiles=schema-genarator
 */

@Component
@Profile("schema-gen")
public class SchemaGenerator implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SchemaGenerator.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Schema generation completed.");
        System.exit(0);
    }

    // target the update of a single entity using command line args (untested)
    // public static void main(String[] args) {
    //     if (args.length == 0) {
    //         System.err.println("Please provide an entity class name as an argument.");
    //         return;
    //     }

    //     String entityClassName = args[0];
    //     try {
    //         // Dynamically load the specified entity class
    //         Class<?> entityClass = Class.forName(entityClassName);
    //         System.out.println("Generating schema for entity: " + entityClass.getName());

    //         Configuration configuration = new Configuration();
    //         configuration.addAnnotatedClass(entityClass);  // Add the dynamically loaded entity
    //         configuration.configure("hibernate.cfg.xml");  // Ensure Hibernate configuration is loaded

    //         SchemaExport schemaExport = new SchemaExport();
    //         schemaExport.setFormat(true);
    //         schemaExport.setDelimiter(";");
    //         schemaExport.create(EnumSet.of(TargetType.SCRIPT), configuration);

    //         System.out.println("Schema generated successfully for entity: " + entityClass.getName());
    //     } catch (ClassNotFoundException e) {
    //         System.err.println("Entity class not found: " + entityClassName);
    //     } catch (Exception e) {
    //         System.err.println("An error occurred while generating the schema: " + e.getMessage());
    //         e.printStackTrace();
    //     }
    // }
}