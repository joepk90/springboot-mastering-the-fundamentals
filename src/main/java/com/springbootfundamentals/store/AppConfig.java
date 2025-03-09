package com.springbootfundamentals.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 
 * AppConfig file: used to configuring beans using code.
 * - note: this file can be called anything - AppConfig is a common practice.
 * 
 * The Configuration Annotationm
 * This tells Springboot that this clasas is a source of bean definition.
 * note: be sure to use the Configuration annotation, not the Configurable annotation.
 * 
 * The Bean Annotation
 * his tells Springboot that this method is a bean producer.
 * 
 */

@Configuration
public class AppConfig {

    @Value("${payment-gateway:stripe}") // stripe is default value
    private String paymentGateway;

    @Bean
    public PaymentService stripe() {
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal() {
        return new PaypalPaymentService();
    }

    @Bean
    // @Scope("prototype")
    public OrderService orderService() {
        if (paymentGateway.equals("stripe")) {
            return new OrderService(stripe());
        }

        return new OrderService(paypal());
    }

   

    // User Registration Rssources

    @Bean
    public NotificationService emailNotificationService() {
        return new EmailNotificationService();
    }

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository(), emailNotificationService());
    }

    @Bean
    public NotificationManager notificationManager() {
        return new NotificationManager(emailNotificationService());
    }

}

/**
 * Bean Scopes
 * 
 * - Singleton (default):
 *   only one instance of the bean (resource) is created per container (app instance)
 * 
 * - Prototype:
 *   a new instance of the bean (resource) is created every time it is requested from the IOC container
 *     - useful for components that hold state or are used temporarily
 * 
 * - Request:
 *   a new instance of the bean (resource) is created on each http request - so the bean
 *   exists only for the duration of the https request
 *   - useful for storing request specific data in web applications
 * 
 * - Session:
 *   a new instance of the bean (resource) is created on each http session - so the bean
 *   exists only for the duration of the https session
 * 
 */