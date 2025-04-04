package com.springbootfundamentals.store.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springbootfundamentals.store.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
    /**
     * Derived Queries
     * Methods that use specific naming conventions can be used by springboot to generate queries at runtime
     * Calling the below methods will generate sqltatements at runtime
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
}



