package com.example.easy_auction.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CSVDto {

    private Integer id;
    private String status;
    private String title;
    private Integer currentPrice;
    private BidderDto lastBid;

    public CSVDto(Integer id, String title, String status, BidderDto lastBid, Integer currentPrice) {
        this.id = id;
        this.status = status;
        this.title = title;
        this.currentPrice = currentPrice;
        this.lastBid = lastBid;
    }
}
