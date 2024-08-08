package com.intuit.auction.repository;

import com.intuit.auction.core.request.AuctionSearchRequest;
import com.intuit.auction.core.entity.Auction;
import com.intuit.auction.repository.QueryBuilder.FilterQueryCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Repository
public class CustomAuctionRepositoryImpl implements CustomAuctionRepository{

    @Autowired
    private ElasticsearchTemplate template;
    @Override
    public List<Auction> searchAuctions(AuctionSearchRequest auctionSearchRequest) {
        CriteriaQuery criteriaQuery = FilterQueryCreator.createFilterQuery(auctionSearchRequest);
        if(Objects.isNull(criteriaQuery)){
            return new ArrayList<>();
        }
        return template.search(criteriaQuery, Auction.class)
                .getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }


}
