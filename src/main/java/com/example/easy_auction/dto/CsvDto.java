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

}
