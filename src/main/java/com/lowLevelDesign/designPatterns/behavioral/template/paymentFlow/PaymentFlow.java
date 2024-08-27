package com.lowLevelDesign.designPatterns.behavioral.template.paymentFlow;

public abstract class PaymentFlow {

    public abstract void validate();
    public abstract void debitAmount();
    public abstract void chargeFees();
    public abstract void creditAmount();

    public final void pay(){
        validate();;
        debitAmount();
        chargeFees();
        creditAmount();
    }


}
