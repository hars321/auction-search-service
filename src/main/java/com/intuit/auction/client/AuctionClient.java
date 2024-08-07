package com.intuit.auction.client;

import com.intuit.auction.core.request.AuctionSearchRequest;
import com.intuit.auction.entity.Auction;
import com.intuit.auction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "auction-service-client", url = "http://localhost:9091/api")
public interface AuctionClient {

    @PostMapping("/v1/auctions/new")
    List<Auction> createAuction(@RequestBody Auction auction);

    @PostMapping("/v1/auctions/search")
    List<Auction> searchAuctions(@RequestBody AuctionSearchRequest auctionSearchRequest);
}
