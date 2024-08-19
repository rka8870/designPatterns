package com.lowLevelDesign.designPatterns.behavioral.state.vendingMachine;

import lombok.Data;

import java.util.List;

@Data
public class VendingMachine {
    List<Item> items;
    List<Coin> coins;
    State state;
}
