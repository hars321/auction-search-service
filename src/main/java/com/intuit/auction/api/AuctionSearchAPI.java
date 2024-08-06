package com.intuit.auction.api;


import com.intuit.auction.entity.Auction;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.intuit.auction.service.AuctionService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/com/intuit/auction/api/v1/auctions")
public class AuctionSearchAPI {

    private AuctionService auctionService;

    @PostMapping("/new")
    public Auction createAuction(@Valid @RequestBody Auction auction) {
        return auctionService.searchAuctions("query").get(0);
    }

    @GetMapping("/search")
    public List<Auction> searchAuctions(@RequestParam String query) {
        return auctionService.searchAuctions("query");
    }
}




