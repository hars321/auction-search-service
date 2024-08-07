package com.intuit.auction.service;

import com.intuit.auction.core.enums.AuctionStatus;
import com.intuit.auction.core.request.AuctionSearchRequest;
import com.intuit.auction.entity.Auction;
import com.intuit.auction.repository.AuctionRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;


    public Auction saveAuction(@NotNull Auction auction) {
        if (isDuplicateProduct(auction.getProductDetails().getId())) {
            throw new RuntimeException("Auction for this product already exists");
        }

        try {
            auction.setListingTimestamp(Instant.now().toEpochMilli());
            auction.setAuctionStatus(AuctionStatus.LISTED);
            return auctionRepository.save(auction);
        } catch (Exception e) {
            System.out.println("Failed to save auction");
        }
        return null;
    }

    public List<Auction> searchAuctions(AuctionSearchRequest auctionSearchRequest) {
        return auctionRepository.searchAuctions(auctionSearchRequest);
    }

    public Auction getAuctionById(String auctionId) {
        Optional<Auction> optionalAuction = auctionRepository.findById(auctionId);
        return optionalAuction.orElse(null);
    }

    private boolean isDuplicateProduct(String productId) {
        AuctionSearchRequest auctionSearchRequest = new AuctionSearchRequest();
        auctionSearchRequest.setProductId(productId);
        if (!CollectionUtils.isEmpty(searchAuctions(auctionSearchRequest))) {
            return true;
        }
        return false;
    }

    public Auction updateAuctionStatus(String auctionId, String auctionStatus) {
        if (auctionRepository.existsById(auctionId)) {
            // Set the ID for the updated document
            Auction auction = auctionRepository.findById(auctionId).get();
            auction.setAuctionStatus(AuctionStatus.valueOf(auctionStatus));
            // Save the updated document
            return auctionRepository.save(auction);
        } else {
            throw new RuntimeException("Document with ID " + auctionId + " does not exist.");
        }
    }
}
