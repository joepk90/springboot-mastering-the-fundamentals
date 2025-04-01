package com.springbootfundamentals.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springbootfundamentals.store.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
}
