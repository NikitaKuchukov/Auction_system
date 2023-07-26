package com.example.easy_auction.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;
@JsonPropertyOrder({"id", "title", "status", "lastBidder", "currentPrice"})
public interface LotCsv {
    int getId();
    String getTitle();

    String getStatus();

    String getLastBidder();

    int getCurrentPrice();
}
