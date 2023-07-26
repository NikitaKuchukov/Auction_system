package com.example.easy_auction.controller;

import com.example.easy_auction.dto.BidderDto;
import com.example.easy_auction.service.BidService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bid")
@RequiredArgsConstructor
public class BidController {

    private final BidService bidService;

    @PostMapping("createBid/{id}")
    public BidderDto createBid(@RequestBody BidderDto bidderDto, @PathVariable int id) {
        return bidService.createBid(bidderDto, id);
    }

    @GetMapping("firstBidder/{id}")
    public BidderDto getFirstBidder(@PathVariable int id) {
        return bidService.findFirstBidder(id);
    }

    @GetMapping("frequentBidder/{id}")
    public BidderDto getFrequentBidder(@PathVariable int id) {
        return bidService.findFrequentBidder(id);
    }


}
