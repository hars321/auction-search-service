package com.intuit.auction.service.states.processor;

import com.intuit.auction.core.enums.AuctionStatus;
import com.intuit.auction.entity.Auction;
import com.intuit.auction.service.states.CompletedAuctionState;
import com.intuit.auction.service.states.DeclinedAuctionState;
import com.intuit.auction.service.states.InProgressAuctionState;
import com.intuit.auction.service.states.ListedAuctionState;
import org.springframework.stereotype.Service;

@Service
public class AuctionStateProcessor {
    public static void process(Auction auction, AuctionStatus nextAuctionStatus) {
        switch (nextAuctionStatus) {
            case LISTED:
                new ListedAuctionState().changeState(auction, nextAuctionStatus);
                break;
            case COMPLETED:
                new CompletedAuctionState().changeState(auction, nextAuctionStatus);
                break;
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
