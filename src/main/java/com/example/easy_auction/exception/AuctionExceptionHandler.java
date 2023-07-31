package com.example.easy_auction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuctionExceptionHandler {

    @ExceptionHandler(LotNotFoundException.class)
    public ResponseEntity<?> handleNotFound(LotNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Лот c id = %d не найден!".formatted(e.getId()));
    }

    @ExceptionHandler(LotStatusException.class)
    public ResponseEntity<?> handleNotFound(LotStatusException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Неверный статус лота: %s".formatted(e.getStatus()));
    }

    @ExceptionHandler(BidNotFoundException.class)
    public ResponseEntity<?> handleNotFound(BidNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Ставок по лоту с id = %d нет".formatted(e.getId()));
    }
}
