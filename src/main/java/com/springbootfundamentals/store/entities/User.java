package com.springbootfundamentals.store.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setUser(null);
    }

    /**
     * JoinTable:
     * - applying the JoinTable here means the User entity is the owner of the relationship
     * - this annotation will mean a new table is created to handle the join
     *   for this entity relationship
     */

    @ManyToMany
    @JoinTable(
        name = "user_tags",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

}
