package com.lowLevelDesign.designPatterns.behavioral.state.vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State{

    IdleState(VendingMachine vendingMachine){
        vendingMachine.setCoins(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {
        vendingMachine.setState(new HasMoneyState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {

    }

    @Override
    public void clickOnSelectProduct(VendingMachine vendingMachine) {

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
