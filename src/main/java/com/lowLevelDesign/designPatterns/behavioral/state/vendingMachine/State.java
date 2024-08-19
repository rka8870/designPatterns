package com.lowLevelDesign.designPatterns.behavioral.state.vendingMachine;

import java.util.List;

public interface State {
    void clickOnInsertCoinButton(VendingMachine vendingMachine);
    void insertCoin(VendingMachine vendingMachine, Coin coin);
    void clickOnSelectProduct(VendingMachine vendingMachine);
    void selectProduct(VendingMachine vendingMachine, Integer code);
    Integer getChange();
    Item dispenseProduct(VendingMachine vendingMachine,Integer code);
    List<Coin> refundFullMoney(VendingMachine vendingMachine);
    void updateInventory(VendingMachine vendingMachine, Item item);
}
