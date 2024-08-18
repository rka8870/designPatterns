package com.lowLevelDesign.designPatterns.behavioral.observable.stockUpdate;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private Integer productId;
    private String productName;
    private Integer quantity;
    private float price;
}
