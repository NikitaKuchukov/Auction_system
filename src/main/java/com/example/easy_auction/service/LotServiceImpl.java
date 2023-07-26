package com.example.easy_auction.service;

import com.example.easy_auction.dto.CsvDto;
import com.example.easy_auction.dto.FullInfoLotDto;
import com.example.easy_auction.dto.LotDto;
import com.example.easy_auction.exception.LotNotFoundException;
import com.example.easy_auction.mapper.CsvMapper;
import com.example.easy_auction.mapper.FullInfoMapper;
import com.example.easy_auction.mapper.LotMapper;
import com.example.easy_auction.model.Lot;
import com.example.easy_auction.model.LotStatus;
import com.example.easy_auction.projection.FullInfoLot;
import com.example.easy_auction.repository.LotRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LotServiceImpl implements LotService {

    private final LotRepository lotRepository;
    private final LotMapper lotMapper;
    private final FullInfoMapper fullInfoMapper;
    private final CsvMapper csvMapper;

    private static final Logger logger = LoggerFactory.getLogger(LotServiceImpl.class);


    @Override
    public LotDto createLot(LotDto lotDto) {
        logger.info("Вызван метод создания лота с данными: {}", lotDto);
        Lot lot = lotRepository.save(lotMapper.toEntity(lotDto));
        LotDto lotDto1 = lotMapper.lotToDto(lotRepository.findById(lot.getId()).orElseThrow(RuntimeException::new));
        logger.info("Создан лот: {}", lotDto1);
        return lotDto1;
    }

    @Override
    public void startBidding(int id) {
        logger.info("Вызван метод начала торгов по лоту с id = {}", id);
        Lot lot = lotRepository.findById(id).orElseThrow(() -> new LotNotFoundException(id));
        logger.info("Начаты торги по лоту с id = {}", id);
        lot.setStatus(LotStatus.STARTED);
        lotRepository.save(lot);
    }

    @Override
    public void stopBidding(int id) {
        logger.info("Вызван метод остановки торгов по лоту с id = {}", id);
        Lot lot = lotRepository.findById(id).orElseThrow(() -> new LotNotFoundException(id));
        lot.setStatus(LotStatus.STOPPED);
        logger.info("Торги по лоту с id = {} остановлены", id);
        lotRepository.save(lot);
    }

    @Override
    public FullInfoLotDto getFullInfoAboutLot(int id) {
        logger.info("Вызван метод получения полной информации по лоту с id = {}", id);
        FullInfoLot fullInfoLot = lotRepository.getFullInfoAboutLot(id).orElseThrow(() -> new LotNotFoundException(id));
        logger.info("Получена полная информация по лоту с id = {}: {}", id, fullInfoLot);
        return fullInfoMapper.toDto(fullInfoLot);
    }

    @Override
    public List<LotDto> getAllLots(int page) {
        logger.info("Вызван метод получения всех лотов по странице {}", page);
        return lotRepository.findAllLots(PageRequest.of(page - 1, 10));
    }

    @Override
    public void exportLotsToCsv(PrintWriter writer) {
        List<CsvDto> list = lotRepository.getLotsForCsv().stream()
                .map(csvMapper::toDto)
                .toList();

        try {
            CSVPrinter printer = CSVFormat.DEFAULT
                    .print(writer);

            printer.printRecords(list);
            printer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
