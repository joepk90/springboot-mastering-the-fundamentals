package com.springbootfundamentals.store.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories") // custom table name, set here to match our existing table schema
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment the id column
    @Column(name = "id")
    private Byte id;

    @Column(name = "name")
    private String name;

    /**
     * mappedBy"
     * tells hy hybernate the category field in the product entity is the owner of the relationship
     */

    @OneToMany(mappedBy = "category") 
    private Set<Product> product = new HashSet<>();

}
