package com.springbootfundamentals.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springbootfundamentals.store.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
    
}
