package com.example.easy_auction.repository;

import com.example.easy_auction.dto.BidderDto;
import com.example.easy_auction.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {

      Optional<BidderDto> findTopByIdOrderByBidDateDesc(@Param("id") int id);

//     @Query("""
//            SELECT new com.example.easy_auction.dto.BidderDto(b.bidderName,b.bidDate)
//            FROM Bid b WHERE b.lot.id=:id ORDER BY b.bidDate ASC LIMIT 1
//            """)
//
        @Query("""
            SELECT new com.example.easy_auction.dto.BidderDto(b.bidderName,b.bidDate)
            FROM Bid b WHERE b.lot.id=:id
            AND b.id = (SELECT b2.id FROM Bid b2 WHERE b2.lot.id = b.lot.id ORDER BY b2.bidDate ASC LIMIT 1)
            """)
    Optional<BidderDto> findFirstBidder(@Param("id") int id);

     @Query("""
            SELECT new com.example.easy_auction.dto.BidderDto(b.bidderName,MAX(b.bidDate))
            FROM Bid b WHERE b.lot.id = :id GROUP BY b.bidderName ORDER BY COUNT(b.lot.id) DESC LIMIT 1
            """)
    Optional<BidderDto> findFrequentBidder(@Param("id") int id);
}
