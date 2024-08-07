package com.intuit.auction.client;

import com.intuit.auction.core.request.AuctionSearchRequest;
import com.intuit.auction.entity.ApiResponse;
import com.intuit.auction.entity.Auction;
import com.intuit.auction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "auction-service-client", url = "http://localhost:9091/api")
public interface AuctionClient {

    @PostMapping("/api/v1/auctions/new")
    ApiResponse<Auction> createAuction(@RequestBody Auction auction);

    @PutMapping("/api/v1/auctions/update")
    ApiResponse<Auction> updateAuctionStatus(
            @RequestParam("auctionId") String auctionId,
            @RequestParam("auctionStatus") String auctionStatus);

    @PostMapping("/api/v1/auctions/search")
    ApiResponse<List<Auction>> searchAuctions(@RequestBody AuctionSearchRequest auctionSearchRequest);

    @GetMapping("/api/v1/auctions/id")
    ApiResponse<Auction> getAuctionById(@RequestParam("auctionId") String auctionId);
}
