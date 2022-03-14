package com.jpmorgan.simplestock.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpmorgan.simplestock.entities.StockData;

public interface StockDataRepository extends JpaRepository<StockData, String> {

}
