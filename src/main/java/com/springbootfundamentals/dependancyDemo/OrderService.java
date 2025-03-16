package com.springbootfundamentals.dependancyDemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;

// @Service
public class OrderService {
    private PaymentService paymentService;

    // @Autowired (only neccessary if the class has multiple contructors)
    // https://docs.spring.io/spring-framework/reference/core/beans/annotation-config/autowired.html#beans-autowired-annotation-constructor-resolution
    // public OrderService() {}

    // @Autowired
    // Qualifier used to in scenerios where we want a specific implemtation 
    // OrderService(Qualifier("stripe") PaymentService paymentService) {}
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;

        // this will be run every time the OrderService class requested because it is a prototype
        System.out.println("OrderService created"); 
    }

    // post construct lifecycle hook: runs just after the construct method (method name can be anything)
    @PostConstruct
    public void init() {
        System.out.println("OrderService PostConstruct");
    }

    // pre destroy lifecycle hook: runs just before the object is destroyed (method name can be anything)
    @PreDestroy
    public void cleanup() {
        System.out.println("OrderService PreDestroy");
    }
    

    public void placeOrder() {
        paymentService.processPayment(10);
    }
}
