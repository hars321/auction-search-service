package com.intuit.auction.service.states;

import com.intuit.auction.core.enums.AuctionStatus;
import com.intuit.auction.service.states.AbstractAuctionState;

import java.util.HashSet;

public class BiddingClosedAuctionState extends AbstractAuctionState {
    @Override
    public HashSet<AuctionStatus> getCurrentPossibleStates() {
        HashSet<AuctionStatus> auctionStatuses = new HashSet<>();
        auctionStatuses.add(AuctionStatus.IN_PROGRESS);
        return auctionStatuses;
    }
}
