package com.springbootfundamentals.store.services;

import com.springbootfundamentals.store.repositories.AddressRepository;
import com.springbootfundamentals.store.repositories.ProfileRepository;
import com.springbootfundamentals.store.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.springbootfundamentals.store.entities.Address;
import com.springbootfundamentals.store.entities.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final EntityManager entityManager;

    /**
     * The @Transactional Annotation
     * THe save method on the UserRepository already uses a transaction. Adding the  @Transactional annotation
     * changes the boundry of a transaction to the entire showEntityStates method.
     */
    @Transactional
    public void showEntityStates() {
        var user = User.builder()
        .name("John Doe")
        .email("john.doe@example.com")
        .password("password")
        .build();

        if (entityManager.contains(user))
            System.out.println("Persistant");
        else
            System.out.println("Transient / Detached");
        

        // all the methods of our repositories are transactional. when the save method is called, a new
        // transction starts. And when the method completes, the transaction ends.
        // While the transaction is active, we have a persistance context.
        userRepository.save(user);

        // if the @Transactional annotation is not added to the showEntityStates method, the entire method
        // won't be considered transactional, and user objcet will be considered as transient/detached (not persisted).
        if (entityManager.contains(user))
            System.out.println("Persistant");
        else
            System.out.println("Transient / Detached");
    }

    // used to monitor the hibernate queries being made - to view lazy vs eager loaded data
    @Transactional // required for the user -> email field to be queried
    public void showRelatedEntities() {
        // var user = userRepository.findById(2L).orElseThrow();
        // System.out.println(user.getEmail());

        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getBio()); // lazy query made just for the profile record 

       /**
        *  More advanced query made to get user record, however the @Transactional annoatation is required!
        // because the findById method is transactional and the fetch stategy is lazy, it does not know what to query 
        // when the user -> email is querues - to fix this, the whole showRelatedEntities method must be considered a transaction
        */
        System.out.println(profile.getUser().getEmail()); 
    }
    public void fetchAddress() {
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getZip()); 
    }

    public void persistRelationship() {
        var user = User.builder()
            .name("John Doe")
            .email("john.doe@example.com")
            .password("password")
            .build();

        var address = Address.builder()
            .street("street")
            .state("state")
            .city("city")
            .zip("zip")
            .build();

        user.addAddress(address);
        
        // the Address does not get saved
        // by default. hibernate doesn't propergate the persist operation, meaning  when it saves the user
        // it doesn't save the related entities - in this case the address
        userRepository.save(user); 
        addressRepository.save(address); // not a nice approach
    }
}

