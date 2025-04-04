package com.springbootfundamentals.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import com.springbootfundamentals.store.entities.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    
    // derived query
    // - find profiles with loyalty points greater than a given value
     @EntityGraph(attributePaths = "user")
     List<Profile> findByLoyaltyPointsGreaterThan(Integer min);

}
