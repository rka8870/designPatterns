package com.lowLevelDesign.designPatterns.behavioral.mediator.auctionSystem;

public interface AuctionMediator {

    public void addBidder(Bidder bidder);
    public void bid(Bidder bidder, int bid);

}
