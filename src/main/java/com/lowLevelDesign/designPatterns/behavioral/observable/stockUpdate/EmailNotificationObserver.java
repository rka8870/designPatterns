package com.lowLevelDesign.designPatterns.behavioral.observable.stockUpdate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmailNotificationObserver implements Observer<Product>{

    private String emailAddress;

    @Override
    public void update(Product product) {
        System.out.println("Email Notification Sent to : " + emailAddress + ". " + product.getProductName() + "is available");
    }

}
