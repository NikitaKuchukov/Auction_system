package com.example.easy_auction.mapper;

import com.example.easy_auction.dto.LotDto;
import com.example.easy_auction.model.Lot;
import com.example.easy_auction.model.LotStatus;
import com.example.easy_auction.repository.BidRepository;
import org.springframework.stereotype.Component;

@Component
public class LotMapper {
    private final BidRepository bidRepository;

    public LotMapper(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public LotDto lotToDto(Lot lot) {
        LotDto lotDto = new LotDto();
        lotDto.setId(lot.getId());
        lotDto.setStatus(lot.getStatus());
        lotDto.setTitle(lot.getTitle());
        lotDto.setDescription(lot.getDescription());
        lotDto.setStartPrice(lot.getStartPrice());
        lotDto.setBidPrice(lot.getBidPrice());
        return lotDto;
    }

    public Lot toEntity(LotDto lotDTO) {
        Lot lot = new Lot();
        lot.setTitle(lotDTO.getTitle());
        lot.setDescription(lotDTO.getDescription());
        lot.setStartPrice(lotDTO.getStartPrice());
        lot.setBidPrice(lotDTO.getBidPrice());
        lot.setStatus(LotStatus.CREATED);
        return lot;
    }
}
