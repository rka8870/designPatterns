package com.lowLevelDesign.designPatterns.structural.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        BasePizza pizza = new MushroomTopping(new CheeseTopping(new VegDelight()));
        System.out.println(pizza.getCost());

        ExecutorService executors = Executors.newFixedThreadPool(2);

        List<Callable<String>> tasks = new ArrayList<>();

        List<Future<String>> futures = executors.invokeAll(tasks);



    }


}
