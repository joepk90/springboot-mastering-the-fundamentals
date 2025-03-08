package com.springbootfundamentals.store;

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

        // this only appears once because the OrderService class is a singleton
        System.out.println("OrderService created"); 
    }

    public void placeOrder() {
        paymentService.processPayment(10);
    }
}
