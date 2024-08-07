package com.intuit.auction.repository.QueryBuilder;

import com.intuit.auction.core.request.AuctionSearchRequest;
import com.intuit.auction.repository.QueryBuilder.filters.*;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class FilterQueryCreator {
    public static CriteriaQuery createFilterQuery(AuctionSearchRequest auctionSearchRequest) {

        List<Criteria> criteriaList = new ArrayList<>();
        for (AbstractFilterAdder filterAdder : getFilterList()) {
            filterAdder.addFilter(auctionSearchRequest, criteriaList);
        }
        if (CollectionUtils.isEmpty(criteriaList)) {
            return null;
        }
        Criteria mustCriteria = criteriaList.get(0);
        for (int index = 1; index < criteriaList.size(); index++) {
            mustCriteria.and(criteriaList.get(index));
        }
        return new CriteriaQuery(mustCriteria);
    }


    public static List<AbstractFilterAdder> getFilterList() {
        List<AbstractFilterAdder> filterAdders = new ArrayList<>();
        filterAdders.add(new CategoryFilterAdder());
        filterAdders.add(new AuctionStatusFilterAdder());
        filterAdders.add(new CategoryFilterAdder());
        filterAdders.add(new CityFilterAdder());
        filterAdders.add(new EndTimeStampFilterAdder());
        filterAdders.add(new StartTimeStampFilterAdder());
        filterAdders.add(new ProductIdFilterAdder());
        return filterAdders;
    }


}
