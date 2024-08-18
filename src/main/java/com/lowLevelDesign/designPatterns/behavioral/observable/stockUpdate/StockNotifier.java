package com.lowLevelDesign.designPatterns.behavioral.observable.stockUpdate;

public class StockNotifier {

    public static void main(String[] args){

        StockObservable<Product> tvObservable = new TVStockObservable();
        Observer<Product> emailNotification = new EmailNotificationObserver("rka8870@gmail.com");
        Observer<Product> mobileNotification = new MobileNotificationObserver("7001156987");
        tvObservable.register(emailNotification);
        tvObservable.register(mobileNotification);
        tvObservable.setData(Product.builder().productId(123).productName("SAMSUNG QLED 45'").quantity(3).price(45000).build());

    }

}
