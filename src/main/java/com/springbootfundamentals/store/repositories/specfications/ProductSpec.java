package com.springbootfundamentals.store.repositories.specfications;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

import com.springbootfundamentals.store.entities.Product;

public class ProductSpec {
    public static Specification<Product> hasName(String name) {
        return (root, query, cb) -> cb.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Product> hasPriceGreaterThanOrEqualTo(BigDecimal price) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> hasPriceLessThanOrEqualTo(BigDecimal price) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> hasCategoryName(String categoryName) {
        return (root, query, cb) -> cb.like(root.join("category").get("name"), "%" + categoryName + "%");
    }
}
