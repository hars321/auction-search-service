package com.intuit.auction.service.states.processor;

import com.intuit.auction.core.enums.AuctionStatus;
import com.intuit.auction.core.entity.Auction;
import com.intuit.auction.service.states.*;
import org.springframework.stereotype.Service;

@Service
public class AuctionStateProcessor {
    public static void process(Auction auction, AuctionStatus nextAuctionStatus) {
        switch (nextAuctionStatus) {
            case LISTED:
                new ListedAuctionState().changeState(auction, nextAuctionStatus);
                break;
            case AUCTION_COMPLETED:
                new CompletedAuctionState().changeState(auction, nextAuctionStatus);
                break;
            case BIDDING_CLOSED:
                new BiddingClosedAuctionState().changeState(auction,nextAuctionStatus);
            case IN_PROGRESS:
                new InProgressAuctionState().changeState(auction, nextAuctionStatus);
                break;
            case DECLINED:
                new DeclinedAuctionState().changeState(auction, nextAuctionStatus);
                break;
            default:
                throw new RuntimeException("Invalid state change");
        }
    }
}
