package com.example.easy_auction.service;

import com.example.easy_auction.dto.FullInfoLotDto;
import com.example.easy_auction.dto.LotDto;

import java.io.IOException;
import java.util.List;

public interface LotService {

    LotDto createLot(LotDto lotDto);

    void startBidding(int id);

    void stopBidding(int id);

    FullInfoLotDto getFullInfoAboutLot(int id);

    void csvFile() throws IOException;

    List<LotDto> getAllLots(int page);
}
