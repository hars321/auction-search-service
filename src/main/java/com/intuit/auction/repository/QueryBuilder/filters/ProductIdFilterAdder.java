package com.intuit.auction.repository.QueryBuilder.filters;

import com.intuit.auction.core.request.AuctionSearchRequest;

import java.util.Objects;

public class ProductIdFilterAdder extends AbstractFilterAdder {


    @Override
    public String getFieldName() {
        return "productDetails.id";
    }

    @Override
    public String getFieldValue(AuctionSearchRequest auctionSearchRequest) {
        return auctionSearchRequest.getProductId().toString();
    }

    @Override
    public boolean isValid(AuctionSearchRequest auctionSearchRequest) {
        if (Objects.nonNull(auctionSearchRequest) && Objects.nonNull(auctionSearchRequest.getProductId())) {
            return true;
        }
        return false;
    }
}
