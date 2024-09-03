package com.lowLevelDesign.designPatterns.structural.decorator;

public class CheeseTopping extends ToppingDecorator{

    BasePizza basePizza;

    public CheeseTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int getCost() {
        return basePizza.getCost() + 20;
    }
}
