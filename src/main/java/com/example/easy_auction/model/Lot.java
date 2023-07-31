package com.example.easy_auction.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(10) default 'CREATED'", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private LotStatus status;

    @Size(min = 3, max = 64, message = "Размер от 3 до 64 символов")
    private String title;

    @Size(min = 1, max = 4096, message = "Размер описания от 1 до 4096 символов")
    private String description;

    @Min(value = 1, message = "Стартовая цена не может быть меньше 1")
    private Integer startPrice;

    @Min(value = 1, message = "Размер ставки не может быть меньше 1")
    private Integer bidPrice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lot")
    private List<Bid> bidList;

    public Lot(LotStatus status, String title, String description, Integer startPrice, Integer bidPrice) {
        this.status = status;
        this.title = title;
        this.description = description;
        this.startPrice = startPrice;
        this.bidPrice = bidPrice;
    }
}
