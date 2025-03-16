package com.springbootfundamentals.store.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories") // custom table name, set here to match our existing table schema
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment the id column
    @Column(name = "id")
    private Byte id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id") // foreign key
    private Product product;

}
