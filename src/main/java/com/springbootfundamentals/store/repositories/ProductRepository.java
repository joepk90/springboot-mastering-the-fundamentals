package com.springbootfundamentals.store.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springbootfundamentals.store.entities.Product;
import com.springbootfundamentals.store.entities.Category;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
    /**
     * Derived Queries
     * Methods that use specific naming conventions can be used by springboot to generate queries at runtime
     * Calling the below methods will generate sqltatements at runtime
     * Extremely useful for simple queries, but it starts to break down as queries become more complex
     */

    // String Column Queries
    List<Product> findByName(String name); // SQL: select * from products where name = 

    // replaces the equality operator with the like operator
    List<Product> findByNameLike(String name);  // SQL: select * from products like name = ?

    List<Product> findByNameNotLike(String name); // SQL: select * from products where name not like name = ?

    List<Product> findByNameContaining(String name); 
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameEndingWithIgnoreCase(String name);

    // Number Column Queries
    List<Product> findByPrice(BigDecimal price); // SQL: select * from products where price = ?
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceGreaterThanEqual(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    // Null Column Queries
    List<Product> findByDescriptionNull();
    List<Product> findByDescriptionNotNull();

    // Multiple Column Queries
    List<Product> findByDescriptionNullAndNameNull();

    // Sort (OrderBy)
    List<Product> findByNameOrderByPriceAsc(String name);

    // Limit (Top/First) - limitation of the number of records returned (5)
    List<Product> findTop5ByNameOrderByPrice(String name);
    List<Product> findFirst5ByNameLikeOrderByPrice(String name);

    // as queries become more complex, our method names become more complex and unreadable (example above)
    // the solution is to use the @Query annotation...


    /**
     * Query Annotation
     * the Query annotation takes either a SQL or JPQL statement
     */

     // example of complex derived query
     // find products whose prices are in a given range and sort by name
     List<Product> findByPriceBetweenOrderByName(BigDecimal min, BigDecimal max);

    // SQL Query Example (nativeQuery = SQL query)
    @Query(value = "SELECT * FROM products p WHERE p.price BETWEEN :min AND :max order by p.name", nativeQuery = true)
    List<Product> findProductsSqlExample(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    /**
     * JPQL Queries:
     * - a query language that is similar to SQL but is object-oriented.
     * - instead of working with the database tables and columns, we work with the entity classes and their properties
     * 
     * Note: I did not manage to get JPQL syntax highlighting to work in VSCode (I didn't attempt too). But in IntelliJ it works.
     */

    // JPQL Query Examples (value might not be required here)
    @Query(value = "SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max order by p.name" )
    List<Product> findProductsJpqlExample(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Query(value = "SELECT p FROM Product p JOIN p.category WHERE p.price BETWEEN :min AND :max order by p.name")
    List<Product> findProductsJpqlExampleWithJoin(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Query(value = "SELECT count(*) from Product p WHERE p.price BETWEEN :min and :max")
    long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Modifying // tell hibernate this is a modify operation, not a select operation
    @Query(value = "UPDATE Product p SET p.price = :newPrice WHERE p.category.id = :categoryId")
    void updatePriceByCategory(BigDecimal newPrice, Byte categoryId);

    /**
     * Projections
     */

    List<Product> findByCategory(Category category); 

}



