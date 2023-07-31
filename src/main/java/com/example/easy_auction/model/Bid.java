package com.example.easy_auction.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bidderName;
    private LocalDateTime bidDate;
    @ManyToOne
    @JoinColumn(name = "lot")
    private Lot lot;

    public Bid(String bidderName, LocalDateTime bidDate, Lot lot) {
        this.bidderName = bidderName;
        this.bidDate = bidDate;
        this.lot = lot;
    }
}
