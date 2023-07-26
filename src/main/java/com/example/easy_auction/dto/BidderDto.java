package com.example.easy_auction.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BidderDto {

    private String bidderName;
    private LocalDateTime bidDate;

    public BidderDto(String bidderName, LocalDateTime bidDate) {
        this.bidderName = bidderName;
        this.bidDate = bidDate;
    }
}
