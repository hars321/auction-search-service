package com.intuit.auction.client;

import com.intuit.auction.entity.Auction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "auction-service", url = "http://localhost:8081")
public interface AuctionClient {

    @GetMapping("/com/intuit/auction/api/auctions")
    List<Auction> getAuctions(@RequestParam("query") String query);
}
