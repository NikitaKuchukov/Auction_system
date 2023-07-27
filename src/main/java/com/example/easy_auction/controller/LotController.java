package com.example.easy_auction.controller;

import com.example.easy_auction.dto.BidderDto;
import com.example.easy_auction.dto.FullInfoLotDto;
import com.example.easy_auction.dto.LotDto;
import com.example.easy_auction.model.Lot;
import com.example.easy_auction.projection.FullInfoLot;
import com.example.easy_auction.service.BidService;
import com.example.easy_auction.service.LotService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("lot")
@RequiredArgsConstructor
public class LotController {

    private final LotService lotService;
    private final BidService bidService;


    @GetMapping("{id}")
    public FullInfoLotDto getFullInfoAboutLot(@PathVariable int id) {
        return lotService.getFullInfoAboutLot(id);
    }

    @PostMapping("{id}/start")
    public void startBidding(@PathVariable int id) {
        lotService.startBidding(id);
    }


    @PostMapping("{id}/stop")
    public void stopBidding(@PathVariable int id) {
        lotService.stopBidding(id);
    }

    @PostMapping()
    public LotDto createLot(@RequestBody LotDto lotDto) {
        return lotService.createLot(lotDto);
    }

    @GetMapping()
    public List<LotDto> getAllLots(@RequestParam(required = false, defaultValue = "0") int page) {
        return lotService.getAllLots(page);
    }

    @GetMapping("export")
    public void exportLotsToCSV(HttpServletResponse response) throws IOException {
        response.addHeader(HttpHeaders.CONTENT_TYPE, "application/csv;charset=windows-1251");
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=LotInfo.csv");
        lotService.exportLotsToCsv(response.getWriter());
    }

    @PostMapping("{id}/bid")
    public BidderDto createBid(@RequestBody BidderDto bidderDto, @PathVariable int id) {
        return bidService.createBid(bidderDto, id);
    }

    @GetMapping("{id}/first")
    public BidderDto getFirstBid(@PathVariable int id) {
        return bidService.findFirstBidder(id);
    }

    @GetMapping("{id}/frequent")
    public BidderDto getFrequentBidder(@PathVariable int id) {
        return bidService.findFrequentBidder(id);
    }
}
