package com.intuit.auction.service.states;

import com.intuit.auction.core.enums.AuctionStatus;

import java.util.HashSet;

public class InProgressAuctionState extends AbstractAuctionState {

    @Override
    public HashSet<AuctionStatus> getCurrentPossibleStates() {
        HashSet<AuctionStatus> auctionStatuses = new HashSet<>();
        auctionStatuses.add(AuctionStatus.LISTED);
        return auctionStatuses;
    }
}
