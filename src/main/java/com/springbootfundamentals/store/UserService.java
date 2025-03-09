package com.springbootfundamentals.store;

public class UserService {

    private UserRepository userRepository;
    private  NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
       this.userRepository = userRepository;
       this.notificationService = notificationService;
    }

    void registerUser(String email) {

        var userCount = userRepository.getUserCount();

        User user = new User(userCount++, email, "John", "password");
        
        userRepository.save(user);
        notificationService.send("user saved", email);
        System.out.println("user has been saved: " + email);
        System.out.println("amount of users saved: " + userRepository.getUserCount());
    }

}
