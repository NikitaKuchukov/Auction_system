package com.example.easy_auction.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;

@JsonPropertyOrder({"id", "status", "title", "description", "startPrice",
        "bidPrice", "currentPrice", "bidderName", "bidDate"})
public interface FullInfoLot {
    int getId();

    String getStatus();

    String getTitle();

    String getDescription();

    int getStartPrice();

    int getBidPrice();

    int getCurrentPrice();

    String getBidderName();

    LocalDateTime getBidDate();
}
