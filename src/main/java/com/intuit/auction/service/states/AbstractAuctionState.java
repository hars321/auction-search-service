package com.intuit.auction.service.states;

import com.intuit.auction.core.enums.AuctionStatus;
import com.intuit.auction.entity.Auction;

import java.util.HashSet;
import java.util.Objects;

public abstract class AbstractAuctionState {
    public void changeState(Auction auction, AuctionStatus nextAuctionStatus) {
        if (Objects.nonNull(auction.getAuctionStatus()) && getCurrentPossibleStates().contains(auction.getAuctionStatus())) {
            auction.setAuctionStatus(nextAuctionStatus);
        }
    }

    public abstract HashSet<AuctionStatus> getCurrentPossibleStates();


}
