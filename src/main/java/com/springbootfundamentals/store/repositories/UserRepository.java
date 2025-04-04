package com.springbootfundamentals.store.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.springbootfundamentals.store.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

    // the entity graph is used to define which associations should be fetched eagerly
    // when the entity is loaded. In this case, we are fetching the tags and addresses
    @EntityGraph(attributePaths = {"tags", "addresses"})
    Optional<User> findByEmail(String email); // SQL: select * from users where email = ?
}
