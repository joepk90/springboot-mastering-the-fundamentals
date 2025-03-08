package com.springbootfundamentals.store;

import org.springframework.stereotype.Service;

@Service("email")
public class EmailNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("EMAIL NOTIFICATION");
        System.out.println(message);
        
    }

}
