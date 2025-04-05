package com.springbootfundamentals.store.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

import org.springframework.stereotype.Repository;

import com.springbootfundamentals.store.entities.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class ProductCriteriaRepositoryImpl implements ProductCriteriaRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Product> findProductsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice, String categoryName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        // root - the root of the query, the entity/table we are querying
        Root<Product> root = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(null);
        if (name != null) {
            // name like %name%
            predicates.add(cb.like(root.get("name"), "%" + name + "%"));
        }

        if (minPrice != null) {
            // price >= minPrice
            predicates.add(cb.greaterThanOrEqualTo(root.get("price"), minPrice));
        }

        if (maxPrice != null) {
            // price <= maxPrice
            predicates.add(cb.lessThanOrEqualTo(root.get("price"), maxPrice));
        }

        if (categoryName != null) {
            predicates.add(cb.like(root.join("category").get("name"), "%" + categoryName + "%"));
        }
        
        cq.select(root)
            .where(predicates.toArray(new Predicate[predicates.size()]));

        // Generated SQL statement:
        // SELECT * FROM products WHERE name LIKE '%name%' AND price >= minPrice AND price <= maxPrice

        // construct the query. execute the query. return the results.
        return entityManager.createQuery(cq)
            .getResultList();

    }    
}
