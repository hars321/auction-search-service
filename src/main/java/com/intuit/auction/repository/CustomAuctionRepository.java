package com.intuit.auction.repository;

import com.intuit.auction.core.request.AuctionSearchRequest;
import com.intuit.auction.core.entity.Auction;

import java.util.List;

public interface CustomAuctionRepository {

    List<Auction> searchAuctions(AuctionSearchRequest auctionSearchRequest);
}
