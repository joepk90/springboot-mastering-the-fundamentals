package com.springbootfundamentals.store.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor // generates a constructor consisting of all the args
@NoArgsConstructor  // generates a constructor consisting of no args (required because we have overriden the default constructor)
@ToString
@Builder
@Entity
@Table(name = "addresses") // custom table name, set here to match our existing table schema
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment the id column
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column( name = "zip")
    private String zip;

    @Column(name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "user_id") // foreign key
    @ToString.Exclude // prevents string conversion cycle in object model (user references addresss -> address references user)
    private User user;
}
