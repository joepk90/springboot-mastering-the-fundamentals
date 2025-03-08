package com.springbootfundamentals.store;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
// import org.springframework.beans.factory.annotation.Autowired;

@Component
public class OrderService {
    private PaymentService paymentService;

    // @Autowired (only neccessary if the class has multiple contructors)
    // https://docs.spring.io/spring-framework/reference/core/beans/annotation-config/autowired.html#beans-autowired-annotation-constructor-resolution
    // public OrderService() {}

    // @Autowired
    // Qualifier used to in scenerios where we want a specific implemtation 
    public OrderService(@Qualifier("stripe") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.processPayment(10);
    }
}
