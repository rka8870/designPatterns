package com.lowLevelDesign.designPatterns.behavioral.observable.stockUpdate;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservable implements StockObservable<Product>{

    List<Observer<Product>> observers = new ArrayList<>();

    Product iPhone;

    @Override
    public void register(Observer<Product> observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer<Product> observer) {

    }

    @Override
    public void notifyObservers() {

    }

    @Override
    public void setData(Product data) {
    }

    @Override
    public Product getData() {
        return null;
    }
}
