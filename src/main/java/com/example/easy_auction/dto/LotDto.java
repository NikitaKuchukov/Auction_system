package com.example.easy_auction.dto;

import com.example.easy_auction.model.LotStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LotDto {

    private int id;
    private String title;
    private LotStatus status;
    private String description;
    private Integer startPrice;
    private Integer bidPrice;


    public LotDto(int id, String title, LotStatus status, String description, Integer startPrice, Integer bidPrice) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.description = description;
        this.startPrice = startPrice;
        this.bidPrice = bidPrice;
    }
}