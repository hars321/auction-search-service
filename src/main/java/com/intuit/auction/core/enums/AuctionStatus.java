package com.intuit.auction.core.enums;

import lombok.Getter;

@Getter
public enum AuctionStatus {
    LISTED, IN_PROGRESS, BIDDING_CLOSED, AUCTION_COMPLETED, DECLINED
}
