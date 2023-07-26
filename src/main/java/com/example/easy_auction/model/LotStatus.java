package com.example.easy_auction.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum LotStatus {

    STARTED("STARTED"),
    STOPPED("STOPPED"),
    CREATED("CREATED");

    private String status;

    LotStatus(String status) {
        this.status = status;
    }
}
