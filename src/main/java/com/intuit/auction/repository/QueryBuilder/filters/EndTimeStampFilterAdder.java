package com.intuit.auction.repository.QueryBuilder.filters;

import com.intuit.auction.core.request.AuctionSearchRequest;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class EndTimeStampFilterAdder extends AbstractFilterAdder {

    @Override
    public Criteria getFilterCriteria(AuctionSearchRequest auctionSearchRequest) {
        return Criteria.where(getFieldName()).lessThanEqual(getFieldValue(auctionSearchRequest));
    }
    @Override
    public String getFieldName() {
        return "auctionEndTimeStamp";
    }

    @Override
    public String getFieldValue(AuctionSearchRequest auctionSearchRequest) {
        return auctionSearchRequest.getEndTimeStamp();
    }

    @Override
    public boolean isValid(AuctionSearchRequest auctionSearchRequest) {
        if(Objects.nonNull(auctionSearchRequest) && !StringUtils.isEmpty(auctionSearchRequest.getEndTimeStamp())){
            return true;
        }
        return false;
    }
}
