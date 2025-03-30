package com.springbootfundamentals.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springbootfundamentals.store.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
