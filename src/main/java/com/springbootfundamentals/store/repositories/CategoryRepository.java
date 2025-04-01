package com.springbootfundamentals.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springbootfundamentals.store.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
    
}
