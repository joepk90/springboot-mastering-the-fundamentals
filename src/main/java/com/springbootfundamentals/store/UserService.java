package com.springbootfundamentals.store;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private  NotificationService notificationService;

   
    public UserService(UserRepository userRepository, NotificationService notificationService) {
       this.userRepository = userRepository;
       this.notificationService = notificationService;
    }

    void registerUser(User user) {

        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists");
        }
        
        userRepository.save(user);
        notificationService.send("You registered successfully", user.getEmail());
    }

}
