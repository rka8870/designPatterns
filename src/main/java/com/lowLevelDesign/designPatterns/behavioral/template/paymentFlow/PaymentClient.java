package com.lowLevelDesign.designPatterns.behavioral.template.paymentFlow;

public class PaymentClient {

    public static void main(String[] args){

        PaymentFlow peerToPeer = new PayToPeer();
        PaymentFlow payToMerchant = new PayToMerchant();
        peerToPeer.pay();
        payToMerchant.pay();
    }


}
