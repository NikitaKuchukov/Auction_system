package com.example.easy_auction.exception;

import lombok.Data;

@Data
public class BidNotFoundException extends RuntimeException{
    private final int id;
}
