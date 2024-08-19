package com.lowLevelDesign.designPatterns.behavioral.state.vendingMachine;

import java.util.List;

public class HasMoneyState implements State{
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {

    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
            vendingMachine.getCoins().add(coin);
    }

    @Override
    public void clickOnSelectProduct(VendingMachine vendingMachine) {
        System.out.println("Selecting Product");
        vendingMachine.setState(new SelectionState());
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, Integer code) {

    }

    @Override
    public Integer getChange() {
        return 0;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, Integer code) {
        return null;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) {
        return List.of();
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item) {

    }
}
