package com.lowLevelDesign.designPatterns.behavioral.observable.stockUpdate;

import java.util.ArrayList;
import java.util.List;

public class TVStockObservable implements StockObservable<Product>{

    private final List<Observer<Product>> observers = new ArrayList<>();

    private Product tv;

    @Override
    public void register(Observer<Product> observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer<Product> observer) {

    }

    @Override
    public void notifyObservers() {
        for(Observer<Product> observer : observers){
            observer.update(tv);
        }
    }

    @Override
    public void setData(Product product) {
        if(tv==null  || (tv.getQuantity()==0 && 0 <product.getQuantity())){
            tv = product;
        }
        notifyObservers();
    }

    @Override
    public Product getData() {
        return tv;
    }
}
