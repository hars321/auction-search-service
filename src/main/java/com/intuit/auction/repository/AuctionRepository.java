package com.intuit.auction.repository;


import com.intuit.auction.entity.Auction;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AuctionRepository extends ElasticsearchRepository<Auction, String> {
    // Custom query methods (if needed)
}
