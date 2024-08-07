package com.intuit.auction.repository.QueryBuilder.filters;

import com.intuit.auction.core.request.AuctionSearchRequest;

import java.util.Objects;

public class CityFilterAdder extends AbstractFilterAdder {


    @Override
    public String getFieldName() {
        return "productDetails.city";
    }

    @Override
    public String getFieldValue(AuctionSearchRequest auctionSearchRequest) {
        return auctionSearchRequest.getCity().toString();
    }

    @Override
    public boolean isValid(AuctionSearchRequest auctionSearchRequest) {
        if (Objects.nonNull(auctionSearchRequest) && Objects.nonNull(auctionSearchRequest.getCity())) {
            return true;
        }
        return false;
    }
}
