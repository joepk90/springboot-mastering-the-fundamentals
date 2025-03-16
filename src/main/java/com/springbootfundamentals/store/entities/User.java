package com.springbootfundamentals.store.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor // generates a constructor consisting of all the args
@NoArgsConstructor  // generates a constructor consisting of no args (required because we have overriden the default constructor)
@ToString
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

    // mappedBy relates to the user field on the address entity
    // it is required for hybernation in order to generate the sql mapping
    @OneToMany(mappedBy = "user") 
    @Builder.Default // tells the builder to include these type of initialisations when creating an object
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);;
    }

}
