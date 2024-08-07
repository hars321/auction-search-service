package com.intuit.auction.api;


import com.intuit.auction.core.request.AuctionSearchRequest;
import com.intuit.auction.entity.ApiResponse;
import com.intuit.auction.entity.Auction;
import com.intuit.auction.service.AuctionService;
import com.intuit.auction.utils.ResponseUtil;
import com.intuit.auction.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/v1/auctions", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuctionSearchAPI {

    @Autowired
    private AuctionService auctionService;

    @PostMapping("/new")
    public ResponseEntity<ApiResponse<Auction>> createAuction(@RequestBody Auction auction) {
        try {
            ValidationUtils.isValidAuction(auction);
            Auction saved = auctionService.saveAuction(auction);
            return ResponseUtil.successResponse(saved, "Success");
        } catch (Exception e) {
            return ResponseUtil.errorResponse("Failed to create this auction", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<Auction>> updateAuctionStatus(@RequestParam("auctionId") String auctionId,@RequestParam("auctionStatus") String auctionStatus) {
        try {
            ValidationUtils.isValidAuctionId(auctionId);
            Auction saved = auctionService.updateAuctionStatus(auctionId,auctionStatus);
            return ResponseUtil.successResponse(saved, "Success");
        } catch (Exception e) {
            return ResponseUtil.errorResponse("Failed to create this auction", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/search")
    public ResponseEntity<ApiResponse<List<Auction>>> searchAuctions(@RequestBody AuctionSearchRequest auctionSearchRequest) {
        List<Auction> auctionList = auctionService.searchAuctions(auctionSearchRequest);
        return ResponseUtil.successResponse(auctionList, "Success");
    }

    @GetMapping("/id")
    public ResponseEntity<ApiResponse<Auction>> getAuctionById(@RequestParam("auctionId") String auctionId) {
        try {
            ValidationUtils.isValidAuctionId(auctionId);
            Auction auction = auctionService.getAuctionById(auctionId);
            if (Objects.isNull(auction))
                ResponseUtil.errorResponse("Auction with given auction Id not found", HttpStatus.NOT_FOUND);
            return ResponseUtil.successResponse(auction, "Success");
        } catch (Exception e) {
            return ResponseUtil.errorResponse("Failed to find this auction", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}




