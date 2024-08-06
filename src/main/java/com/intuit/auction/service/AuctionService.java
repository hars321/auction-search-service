package com.intuit.auction.service;

import com.intuit.auction.client.AuctionClient;
import com.intuit.auction.entity.Auction;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.intuit.auction.repository.AuctionRepository;

import java.util.List;

@Service
@Validated
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private AuctionClient auctionClient;  // Inject the Feign client

    public Auction saveAuction(@NotNull Auction auction) {
        return auctionRepository.save(auction);
    }

    public List<Auction> searchAuctions(String query) {
        // Use the Feign client to call another service
        return auctionClient.getAuctions(query);
    }
}
