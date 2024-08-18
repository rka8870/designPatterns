package com.lowLevelDesign.designPatterns.behavioral.observable.stockUpdate;

public interface StockObservable<T> {

    void register(Observer<T> observer);
    void remove(Observer<T> observer);
    void notifyObservers();
    void setData(T data);
    T getData();

}
