package com.springbootfundamentals.store.repositories;

import java.math.BigDecimal;
import java.util.List;

import com.springbootfundamentals.store.entities.Product;

public interface ProductCriteriaRepository {
    List<Product> findProductsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice);
}
