package com.cognizant.orm_learn.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{
    // Facebook stocks in September 2019
    List<Stock> findByCodeAndDateBetween(
            String code,
            LocalDate startDate,
            LocalDate endDate
    );


    // Google stocks where close price > 1250
    List<Stock> findByCodeAndCloseGreaterThan(
            String code,
            double close
    );


    // Highest volume transactions
    List<Stock> findTop3ByOrderByVolumeDesc();


    // Netflix lowest closing prices
    List<Stock> findTop3ByCodeOrderByCloseAsc(
            String code
    );
//s
}