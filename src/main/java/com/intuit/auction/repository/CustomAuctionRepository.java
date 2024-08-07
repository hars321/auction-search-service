package com.intuit.auction.repository;

import com.intuit.auction.core.request.AuctionSearchRequest;
import com.intuit.auction.entity.Auction;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomAuctionRepository {

    List<Auction> searchAuctions(AuctionSearchRequest auctionSearchRequest);
}
