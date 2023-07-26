package com.example.easy_auction.controller;

import com.example.easy_auction.dto.FullInfoLotDto;
import com.example.easy_auction.dto.LotDto;
import com.example.easy_auction.model.Lot;
import com.example.easy_auction.projection.FullInfoLot;
import com.example.easy_auction.service.LotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lot")
@RequiredArgsConstructor
public class LotController {

    private final LotService lotService;

    @GetMapping("fullInfo/{id}")
    public FullInfoLotDto getFullInfoAboutLot(@PathVariable int id) {
       return lotService.getFullInfoAboutLot(id);
    }

    @PostMapping("start/{id}")
    public void startBidding(@PathVariable int id) {
        lotService.startBidding(id);
    }


    @PostMapping("stop/{id}")
    public void stopBidding(@PathVariable int id) {
        lotService.stopBidding(id);
    }

    @PostMapping("createLot")
    public LotDto createLot(@RequestBody LotDto lotDto) {
        return lotService.createLot(lotDto);
    }

    @GetMapping("getAll")
    public List<LotDto> getAllLots(@RequestParam(required = false, defaultValue = "0") int page) {
        return lotService.getAllLots(page);
    }

    @GetMapping("export")
    public void exportLotsToCSV() {

    }


}
