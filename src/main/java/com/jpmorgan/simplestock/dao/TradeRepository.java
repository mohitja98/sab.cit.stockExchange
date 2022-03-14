package com.jpmorgan.simplestock.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpmorgan.simplestock.entities.TradeEntity;

public interface TradeRepository extends JpaRepository<TradeEntity, String> {

	@Query("select t from TradeEntity t where t.stockSymbol = :stockSymbol")
	public List<TradeEntity> getAllTrades(@Param("stockSymbol") final String stockSymbol);
}
