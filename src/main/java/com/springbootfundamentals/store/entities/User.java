package com.springbootfundamentals.store.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

    public void addTag(String tagName) {
        var tag = new Tag(tagName);
        tags.add(tag);
        tag.getUsers().add(this);
    }

    // public void removeTag(Tag tag) {
    //     tags.remove(tag);
    //     tag.getUsers().remove(this);
    // }

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
    @Builder.Default // initialise the tags field on user instantiation (when using the builder method)
    private Set<Tag> tags = new HashSet<>();    

    /**
     * Lazy loading vs Eager Loading
     * Example OneToOne annotation using lazy loading instead of eager - however for this to work it
     * needs to be handled by the owner of the relationship - the Profile:
     * 
     * # @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
     */

    // OneToOne uses eager loading by default. 
    @OneToOne(mappedBy = "user")
    private Profile profile;

    /**
     *  faverouteProducts (wishlist)
     *  We could add the inverse relationship to the product entity. However in this case it is unnesssecary.
     *  Because in relatity, once we have a product object, we don't need to show all the users that have that
     *  product in their wishlist - there is no need to navigate from the product oject to a list of users.
    */
    @ManyToMany
    @JoinTable(
        name = "wishlist",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @Builder.Default // initialise the tags field on user instantiation (when using the builder method)
    private Set<Product> faverouteProducts = new HashSet<>();
}
