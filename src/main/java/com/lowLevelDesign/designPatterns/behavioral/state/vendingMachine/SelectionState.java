package com.lowLevelDesign.designPatterns.behavioral.state.vendingMachine;

import org.springframework.util.StringUtils;

import java.util.List;

public class SelectionState implements State{
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {

    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {

    }

    @Override
    public void clickOnSelectProduct(VendingMachine vendingMachine) {

    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, Integer code) {
            List<Item> items = vendingMachine.getItems();
            Item selected = null;
            for(Item item : items){
                if(item.getCode()==code){
                    selected = item;
                    break;
                }
            }
            int total = 0;
            for(Coin coin : vendingMachine.getCoins()){
                total += coin.getValue();
            }
            if(selected!=null){
                if(total> selected.getPrice()){
                    System.out.println("Return the change");
                } else if(total< selected.getPrice()){
                    vendingMachine.setState(new IdleState(vendingMachine));
                    //throw Exception("");
                }
                vendingMachine.setState(new DispenseState());
            }
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
