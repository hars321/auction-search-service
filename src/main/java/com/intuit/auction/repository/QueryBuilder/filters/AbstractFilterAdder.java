package com.intuit.auction.repository.QueryBuilder.filters;

import com.intuit.auction.core.request.AuctionSearchRequest;
import org.springframework.data.elasticsearch.core.query.Criteria;

import java.util.List;

public abstract class AbstractFilterAdder {

    public void addFilter(AuctionSearchRequest auctionSearchRequest, List<Criteria> criteriaList){
        if(isValid(auctionSearchRequest)) {
            criteriaList.add(getFilterCriteria(auctionSearchRequest));
        }
    }

    public Criteria getFilterCriteria(AuctionSearchRequest auctionSearchRequest){
        return Criteria.where(getFieldName()).is(getFieldValue(auctionSearchRequest));
    }
    public abstract String getFieldName();
    public abstract String getFieldValue(AuctionSearchRequest auctionSearchRequest);
    public abstract boolean isValid(AuctionSearchRequest auctionSearchRequest);
}
