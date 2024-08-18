package com.lowLevelDesign.designPatterns.behavioral.observable.stockUpdate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MobileNotificationObserver implements Observer<Product>{

    private String phoneNo;

    @Override
    public void update(Product product) {
        System.out.println("Mobile Notification Sent to : " + phoneNo+ ". " + product.getProductName() + "is available");

    }
}
