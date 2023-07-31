package com.example.easy_auction.mapper;

import com.example.easy_auction.dto.BidderDto;
import com.example.easy_auction.dto.FullInfoLotDto;
import com.example.easy_auction.projection.FullInfoLot;
import org.springframework.stereotype.Component;

@Component
public class FullInfoMapper {

    public FullInfoLotDto toDto(FullInfoLot f) {
        FullInfoLotDto fd = new FullInfoLotDto();
        fd.setId(f.getId());
        fd.setStatus(f.getStatus());
        fd.setTitle(f.getTitle());
        fd.setDescription(f.getDescription());
        fd.setStartPrice(f.getStartPrice());
        fd.setBidPrice(f.getBidPrice());
        fd.setCurrentPrice(f.getCurrentPrice());
        fd.setLastBid(new BidderDto(f.getBidderName(), f.getBidDate()));
        return fd;
    }
}
