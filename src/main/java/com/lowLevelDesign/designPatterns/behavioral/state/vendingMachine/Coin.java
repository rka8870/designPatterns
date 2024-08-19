package com.lowLevelDesign.designPatterns.behavioral.state.vendingMachine;

import lombok.Getter;

@Getter
public enum Coin {

    PENNY(1),NICKEL(5),DIEM(10),QUARTER(25);

    private final int value;

    Coin(int value) {
        this.value = value;
    }
}
