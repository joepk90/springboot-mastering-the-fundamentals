package com.springbootfundamentals.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springbootfundamentals.store.entities.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
