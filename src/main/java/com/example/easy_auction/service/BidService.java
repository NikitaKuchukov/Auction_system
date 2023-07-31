package com.example.easy_auction.service;

import com.example.easy_auction.dto.BidderDto;


public interface BidService {

    BidderDto createBid(BidderDto bidderDto, int id);
    BidderDto findFirstBidder(int id);
    BidderDto findFrequentBidder(int id);
}
