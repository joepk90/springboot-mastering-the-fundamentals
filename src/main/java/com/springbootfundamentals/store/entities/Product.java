package com.springbootfundamentals.store.entities;

import java.math.BigDecimal;
import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
// import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products") // custom table name, set here to match our existing table schema
public class Product {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment the id column
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    /**
     * Product is the owner of the category/product relationship,
     * because it has the foreign key which references the category
     */
    @ManyToOne(
        // cascade - required in order to persist the related category object when saving the object
        // using the ProductRepository
        cascade = CascadeType.PERSIST
    )
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     * usersInWishlist: Unnessesary Relationship 
     * - Added for documentation purposes. See Users entity for more details
     */
    // @ManyToMany(mappedBy = "faverouteProducts")
    // @Builder.Default
    // private Set<User> usersInWishlist = new HashSet<>();
}
