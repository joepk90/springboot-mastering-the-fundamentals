package com.springbootfundamentals.store.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springbootfundamentals.store.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

    // the entity graph is used to define which associations should be fetched eagerly
    // when the entity is loaded. In this case, we are fetching the tags and addresses
    @EntityGraph(attributePaths = {"tags", "addresses"})
    Optional<User> findByEmail(String email); // SQL: select * from users where email = ?

    // using the EntityGraph annotation this method will fetch all users and their addresses with a single query
    // custom query is used becuase the method name breaks the convention of hibernates derived query syntax
    @EntityGraph(attributePaths = "addresses")
    @Query("select u from User u")
    List<User> findAllWithAddresses();
}
