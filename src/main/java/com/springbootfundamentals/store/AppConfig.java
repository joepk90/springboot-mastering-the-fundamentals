package com.springbootfundamentals.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public OrderService orderService() {
        if (paymentGateway.equals("stripe")) {
            return new OrderService(stripe());
        }

        return new OrderService(paypal());
    }
}

/**
 * Bean Scopes
 * 
 * - Singleton (default):
 *   only one instance of the bean (resource) is created per container (app instance)
 * 
 */