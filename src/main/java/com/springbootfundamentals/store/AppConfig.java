package com.springbootfundamentals.store;

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
        return new OrderService(stripe());
    }
}
