package com.springbootfundamentals.store.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // generates a constructor consisting of all the args
@NoArgsConstructor  // generates a constructor consisting of no args (required because we have overriden the default constructor)
@Builder
@Entity
@Table(name = "users") // custom table name, set here to match our existing table schema
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment the id column
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
