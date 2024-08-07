package com.intuit.auction.repository;


import com.intuit.auction.entity.Auction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuctionRepository extends ElasticsearchRepository<Auction, String>, CustomAuctionRepository {
    // Custom query methods (if needed)
    Page<Auction> findByAuctionStatus(String conditionField, Pageable pageable);

    Page<Auction> findAll();

    Optional<Auction> findById(String auctionId);
}
