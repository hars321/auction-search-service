package com.intuit.auction.repository.QueryBuilder.filters;

import com.intuit.auction.core.request.AuctionSearchRequest;
import org.apache.catalina.util.ToStringUtil;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class CategoryFilterAdder extends AbstractFilterAdder {

    @Override
    public String getFieldName() {
        return "productDetails.category";
    }

    @Override
    public String getFieldValue(AuctionSearchRequest auctionSearchRequest) {
        return auctionSearchRequest.getCategory();
    }

    @Override
    public boolean isValid(AuctionSearchRequest auctionSearchRequest) {
        if(Objects.nonNull(auctionSearchRequest) && !StringUtils.isEmpty(auctionSearchRequest.getCategory())){
            return true;
        }
        return false;
    }
}
