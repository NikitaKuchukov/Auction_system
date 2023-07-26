package com.example.easy_auction.mapper;

import com.example.easy_auction.dto.CsvDto;
import com.example.easy_auction.projection.LotCsv;
import org.springframework.stereotype.Component;

@Component
public class CsvMapper {

    public CsvDto toDto(LotCsv lotCsv) {
        CsvDto csvDto = new CsvDto();
        csvDto.setId(lotCsv.getId());
        csvDto.setTitle(lotCsv.getTitle());
        csvDto.setStatus(lotCsv.getStatus());
        csvDto.setLastBidder(lotCsv.getLastBidder());
        csvDto.setCurrentPrice(lotCsv.getCurrentPrice());
        return csvDto;
    }
}
