package com.intuit.auction.repository.QueryBuilder.filters;

import com.intuit.auction.core.request.AuctionSearchRequest;
import com.intuit.auction.repository.QueryBuilder.filters.AbstractFilterAdder;

import java.util.Objects;

public class AuctionStatusFilterAdder extends AbstractFilterAdder {


    @Override
    public String getFieldName() {
        return "auctionStatus";
    }

    @Override
    public String getFieldValue(AuctionSearchRequest auctionSearchRequest) {
        return auctionSearchRequest.getAuctionStatus().toString();
    }

    @Override
    public boolean isValid(AuctionSearchRequest auctionSearchRequest) {
        if (Objects.nonNull(auctionSearchRequest) && Objects.nonNull(auctionSearchRequest.getAuctionStatus())) {
            return true;
        }
        return false;
    }
}
