package com.example.easy_auction.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CsvDto {

    private Integer id;
    private String status;
    private String title;
    private Integer currentPrice;
    private String lastBidder;

    public CsvDto(Integer id, String title, String status, String lastBid, Integer currentPrice) {
        this.id = id;
        this.status = status;
        this.title = title;
        this.currentPrice = currentPrice;
        this.lastBidder = lastBid;
    }
}
