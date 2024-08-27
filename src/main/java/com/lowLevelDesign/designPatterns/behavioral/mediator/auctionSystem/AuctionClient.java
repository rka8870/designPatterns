package com.lowLevelDesign.designPatterns.behavioral.mediator.auctionSystem;

public class AuctionClient {


    public static void main(String[] args){
        AuctionMediator auction = new Auction();

        Bidder csk = new Participant(auction,"CSK");
        Bidder kkr = new Participant(auction,"KKR");
        Bidder mi = new Participant(auction,"MI");

        auction.addBidder(csk);
        auction.addBidder(mi);
        auction.addBidder(kkr);

        csk.makeBid(120000);
        kkr.makeBid(130000);
        csk.makeBid(140000);
        mi.makeBid(160000);
    }

}
