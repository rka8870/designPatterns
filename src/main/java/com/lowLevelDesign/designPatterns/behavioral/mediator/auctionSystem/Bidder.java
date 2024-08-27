package com.lowLevelDesign.designPatterns.behavioral.mediator.auctionSystem;

public interface Bidder {

    void makeBid(int bid);
    void receiveBidNotification(int bid);

}
