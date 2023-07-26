package com.example.easy_auction.service;

import com.example.easy_auction.dto.BidderDto;
import com.example.easy_auction.exception.BidNotFoundException;
import com.example.easy_auction.exception.LotNotFoundException;
import com.example.easy_auction.exception.LotStatusException;
import com.example.easy_auction.mapper.BidderMapper;
import com.example.easy_auction.model.Bid;
import com.example.easy_auction.model.Lot;
import com.example.easy_auction.model.LotStatus;
import com.example.easy_auction.repository.BidRepository;
import com.example.easy_auction.repository.LotRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class BidServiceImpl implements BidService {

    private final BidRepository bidRepository;
    private final LotRepository lotRepository;
    private final BidderMapper bidderMapper;

    private static final Logger logger = LoggerFactory.getLogger(BidServiceImpl.class);


    @Override
    public BidderDto createBid(BidderDto bidderDto, int id) {
        logger.info("Создание ставки на лот c id = {}", id);
        Lot lot = lotRepository.findById(id).orElseThrow(() -> new LotNotFoundException(id));
        if (lot.getStatus().equals(LotStatus.STARTED)) {
            Bid bid = new Bid(bidderDto.getBidderName(), bidderDto.getBidDate(), lot);
//            bidderMapper.toEntity(bidderDto);
//            bid.setLot(lot);
            bidRepository.save(bid);
            logger.info("Создана новая ставка на лот с id: {}. Поставил(а): {}", lot.getId(), bidderDto.getBidderName());
            return bidderDto;
        } else throw new LotStatusException(lot.getStatus());
    }

    @Override
    public BidderDto findFirstBidder(int id) {
        logger.info("Вызван метод получения информации о первом ставившем на лот с id = {}", id);
        BidderDto bidderDto = bidRepository.findFirstBidder(id).orElseThrow(() -> new BidNotFoundException(id));
        logger.info("Получена информация о первом ставившем на лот с id = {}: {} ", id, bidderDto);
        return bidderDto;
    }

    @Override
    public BidderDto findFrequentBidder(int id) {
        logger.info("Вызван метод получения имени ставившего наибольшее количество раз на лот с id = {}", id);
        BidderDto bidderDto = bidRepository.findFrequentBidder(id).orElseThrow(() -> new LotNotFoundException(id));
        logger.info("Получено имя ставившего на лот с id = {}: {} ", id, bidderDto);
//        BidderDto finalBidder = new BidderDto(bidderDto.getBidderName(), bidderDto.getBidDate());
        return bidderDto;
    }
}
