package com.lowLevelDesign.designPatterns.behavioral.template.paymentFlow;

public class PayToMerchant extends PaymentFlow{
    @Override
    public void validate() {
        System.out.println("Validated merchant payment request");
    }

    @Override
    public void debitAmount() {

    }

    @Override
    public void chargeFees() {
        System.out.println("2% fees charged");
    }

    @Override
    public void creditAmount() {

    }
}
