package com.lowLevelDesign.designPatterns.structural.decorator;


public class MushroomTopping extends ToppingDecorator{

    BasePizza basePizza;

    public MushroomTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int getCost() {
        return basePizza.getCost() + 30;
    }
}
