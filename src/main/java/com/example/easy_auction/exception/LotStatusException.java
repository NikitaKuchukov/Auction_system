package com.example.easy_auction.exception;

import com.example.easy_auction.model.LotStatus;
import lombok.Data;

@Data
public class LotStatusException extends RuntimeException{

    private final LotStatus status;
}
