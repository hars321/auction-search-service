package com.intuit.auction.api;


import com.intuit.auction.core.request.AuctionSearchRequest;
import com.intuit.auction.entity.ApiResponse;
import com.intuit.auction.entity.Auction;
import com.intuit.auction.utils.ResponseUtil;
import com.intuit.auction.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import com.intuit.auction.service.AuctionService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/v1/auctions", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuctionSearchAPI {

    @Autowired
    private AuctionService auctionService;

    @PostMapping("/new")
    public ResponseEntity<ApiResponse<Auction>> createAuction(@RequestBody Auction auction) {
        if(!ValidationUtils.isValidAuction(auction)){
            return ResponseUtil.errorResponse("Invalid request for auction",HttpStatus.BAD_REQUEST);
        }
        Auction saved = auctionService.saveAuction(auction);
        if(Objects.nonNull(saved)){
            return ResponseUtil.successResponse(saved,"Success");
        }
        return ResponseUtil.errorResponse("Failed to create this auction",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/search")
    public ResponseEntity<ApiResponse<List<Auction>>> searchAuctions(@RequestBody AuctionSearchRequest auctionSearchRequest) {
        List<Auction> auctionList = auctionService.searchAuctions(auctionSearchRequest);
        if(!CollectionUtils.isEmpty(auctionList)){
            return ResponseUtil.successResponse(auctionList,"Success");
        }
        return ResponseUtil.errorResponse("No Auction found for given filters", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/id")
    public ResponseEntity<ApiResponse<Auction>> getAuctionById(@RequestBody AuctionSearchRequest auctionSearchRequest) {
        Auction auction = auctionService.getAuctionById(auctionSearchRequest);
        if(Objects.nonNull(auction)){
            return ResponseUtil.successResponse(auction,"Success");
        }
        return ResponseUtil.errorResponse("Auction with given auction Id not found",HttpStatus.NOT_FOUND);
    }
}




