package com.example.easy_auction.mapper;

import com.example.easy_auction.dto.BidderDto;
import com.example.easy_auction.model.Bid;
import org.springframework.stereotype.Component;

@Component
public class BidderMapper {

    public Bid toEntity(BidderDto bidderDto){
        Bid bid = new Bid();
        bid.setBidderName(bidderDto.getBidderName());
        bid.setBidDate(bidderDto.getBidDate());
        return bid;
    }
}
