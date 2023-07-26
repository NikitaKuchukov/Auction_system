package com.example.easy_auction.repository;

import com.example.easy_auction.dto.FullInfoLotDto;
import com.example.easy_auction.dto.LotDto;
import com.example.easy_auction.model.Lot;
import com.example.easy_auction.projection.FullInfoLot;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LotRepository extends JpaRepository<Lot, Integer> {

    @Query(value = """
            SELECT l.id as id, l.status as status, l.title as title,
            l.description as description, l.start_price as startPrice, l.bid_price as bidPrice,
            (l.start_price + l.bid_price * (SELECT COUNT(lot) FROM Bid b WHERE b.lot = l.id)) AS currentPrice,
            b2.bidder_name as bidderName, b2.bid_date as bidDate FROM lot l INNER JOIN bid b2 ON l.id = :id
            AND b2.bid_date = (SELECT MAX(b3.bid_date) FROM Bid b3 WHERE b3.lot = :id)
            """,
            nativeQuery = true)
    Optional<FullInfoLot> getFullInfoAboutLot(@Param("id") int id);


    @Query("""
            SELECT new com.example.easy_auction.dto.LotDto(l.id, l.title,l.status, l.description, l.startPrice, l.bidPrice)
             FROM Lot l
             """)
    List<LotDto> findAllLots(PageRequest of);

}
