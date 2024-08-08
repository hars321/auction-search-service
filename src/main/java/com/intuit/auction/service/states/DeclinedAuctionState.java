package com.intuit.auction.service.states;

import com.intuit.auction.core.enums.AuctionStatus;

import java.util.HashSet;


public class DeclinedAuctionState extends AbstractAuctionState {

    @Override
    public HashSet<AuctionStatus> getCurrentPossibleStates() {
        HashSet<AuctionStatus> auctionStatuses = new HashSet<AuctionStatus>();
        auctionStatuses.add(AuctionStatus.IN_PROGRESS);
        auctionStatuses.add(AuctionStatus.LISTED);
        auctionStatuses.add(AuctionStatus.BIDDING_CLOSED);
        auctionStatuses.add(AuctionStatus.AUCTION_COMPLETED);
        return auctionStatuses;
    }

}
