package com.intuit.auction.entity;

import com.intuit.auction.core.enums.AuctionStatus;
import lombok.Data;

@Data
public class Auction {
    private String id;
    private UserDetails vendor;
    private ProductDetails productDetails;
    private AuctionStatus auctionStatus;
    private Long listingTimestamp;
    private Long auctionStartTimestamp;
    private Long auctionEndTimeStamp;
    private AuctionPricing auctionPricing;
}
