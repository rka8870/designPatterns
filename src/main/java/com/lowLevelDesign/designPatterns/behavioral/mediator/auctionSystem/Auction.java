package com.lowLevelDesign.designPatterns.behavioral.mediator.auctionSystem;

import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator{

    private List<Bidder> bidders;

    public Auction() {
        this.bidders = new ArrayList<>();
    }

    @Override
    public void addBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    @Override
    public void bid(Bidder bidder, int bid) {
        for(Bidder participant : bidders){
            if(!participant.equals(bidder)){
                participant.receiveBidNotification(bid);
            }
        }
    }
}
