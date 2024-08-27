package com.lowLevelDesign.designPatterns.behavioral.mediator.auctionSystem;

public class Participant implements Bidder{

    private AuctionMediator auctionMediator;
    private String name;

    public Participant(AuctionMediator auctionMediator,String name) {
        this.auctionMediator = auctionMediator;
        this.name = name;
    }

    @Override
    public void makeBid(int bid) {
        auctionMediator.bid(this,bid);
    }

    @Override
    public void receiveBidNotification(int bid) {
        System.out.println( name + " : received notification for latest bid :- " + bid);
    }
}
