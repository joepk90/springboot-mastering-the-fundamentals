package com.springbootfundamentals.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springbootfundamentals.store.entities.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    
    // derived query
    // - find profiles with loyalty points greater than a given value
    @EntityGraph(attributePaths = "user")
    List<Profile> findByLoyaltyPointsGreaterThanOrderByUserEmail(Integer min);

    // JPQL Queries
    @EntityGraph(attributePaths = "user")
    @Query("SELECT p FROM Profile p WHERE p.loyaltyPoints > :loyaltypoints ORDER BY p.user.email")
    List<Profile> findByLoyaltyPoints(@Param("loyaltypoints") Integer loyaltyPoints);


}
