package com.lowLevelDesign.designPatterns.behavioral.template.paymentFlow;

public class PayToPeer extends PaymentFlow{
    @Override
    public void validate() {
        System.out.println("Validated peer payment request");
    }

    @Override
    public void debitAmount() {

    }

    @Override
    public void chargeFees() {
        System.out.println(" 0 fees charged for this short of request");
    }

    @Override
    public void creditAmount() {

    }
}
