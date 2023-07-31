package com.example.easy_auction.service;

import com.example.easy_auction.dto.FullInfoLotDto;
import com.example.easy_auction.dto.LotDto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public interface LotService {

    LotDto createLot(LotDto lotDto);

    void startBidding(int id);

    void stopBidding(int id);

    FullInfoLotDto getFullInfoAboutLot(int id);

    List<LotDto> getAllLots(int page);

    void exportLotsToCsv(PrintWriter writer);
}
