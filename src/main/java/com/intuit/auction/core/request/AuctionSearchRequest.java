package com.intuit.auction.core.request;

import lombok.Data;

@Data
public class AuctionSearchRequest {
    private String name;
    private String city;
    private Long startTimeStamp;
    private Long endTimeStamp;
}
