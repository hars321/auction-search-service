package com.intuit.auction.utils;

import com.intuit.auction.core.entity.Auction;
import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.Objects;

@UtilityClass
public class ValidationUtils {
    public static void isValidAuction(Auction auction) {
        if (Objects.isNull(auction)
                || Objects.isNull(auction.getAuctionPricing())
                || Objects.isNull(auction.getAuctionPricing().getListedPrice())
                || Objects.isNull(auction.getAuctionStartTimestamp())
                || Objects.isNull(auction.getAuctionEndTimeStamp())
                || auction.getAuctionStartTimestamp() < Instant.now().toEpochMilli()
                || auction.getAuctionEndTimeStamp() < Instant.now().toEpochMilli()
                || Objects.isNull(auction.getProductDetails())
                || StringUtils.isEmpty(auction.getProductDetails().getId())
                || StringUtils.isEmpty(auction.getProductDetails().getCategory())
                || StringUtils.isEmpty(auction.getProductDetails().getName())
                || StringUtils.isEmpty(auction.getProductDetails().getCity())
                || Objects.isNull(auction.getVendor())
                || StringUtils.isEmpty(auction.getVendor().getId())) {
            throw new RuntimeException("Invalid auction request");
        }
    }

    public static void isValidAuctionId(String auctionId) {
        if(StringUtils.isEmpty(auctionId)){
            throw new RuntimeException("Invalid auction Id");
        }
    }
}
