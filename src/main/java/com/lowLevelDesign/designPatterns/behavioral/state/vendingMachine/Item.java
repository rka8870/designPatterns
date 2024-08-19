package com.lowLevelDesign.designPatterns.behavioral.state.vendingMachine;


import lombok.Data;

@Data
public class Item {
    private ItemType itemType;
    private Integer code;
    private Integer price;
    private Boolean isSoldOut;
}
