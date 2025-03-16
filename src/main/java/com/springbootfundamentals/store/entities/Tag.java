package com.springbootfundamentals.store.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Tag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment the id column
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;
}
