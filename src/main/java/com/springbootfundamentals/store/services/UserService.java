package com.springbootfundamentals.store.services;

import com.springbootfundamentals.store.repositories.ProfileRepository;
import com.springbootfundamentals.store.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.springbootfundamentals.store.entities.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
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
    public void showRelatedEntities() {
        // var user = userRepository.findById(2L).orElseThrow();
        // System.out.println(user.getEmail());

        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getBio()); // lazy query made just for the profile record 
    }
}
