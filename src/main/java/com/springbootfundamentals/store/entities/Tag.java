package com.springbootfundamentals.store.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tags") // custom table name, set here to match our existing table schema
public class Tag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment the id column
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "tags")
    @ToString.Exclude // prevents string conversion cycle in object model (user references tag -> tag references user)
    private Set<User> users = new HashSet<>();

    public Tag(String name) {
        this.name = name;
    }
}
