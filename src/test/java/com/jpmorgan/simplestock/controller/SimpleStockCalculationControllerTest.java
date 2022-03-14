/*
 * This code contains copyright information which is the proprietary property
 * of Mohit Jain Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * Mohit Jain Solutions.
 *
 * Copyright Mohit Jain 2022
 * Confidential. All rights reserved.
 */
package com.jpmorgan.simplestock.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jpmorgan.simplestock.constants.ResponseConstants;
import com.jpmorgan.simplestock.request.Trade;
import com.jpmorgan.simplestock.request.TradeType;
import com.jpmorgan.simplestock.response.CalculateDividendResponse;
import com.jpmorgan.simplestock.response.CalculatePERatioResponse;
import com.jpmorgan.simplestock.response.CalculateVolumeWeightedPriceResponse;
import com.jpmorgan.simplestock.response.GetAllTradesResponse;
import com.jpmorgan.simplestock.response.TradeRecordMessage;

/**
 * Rest Controller test.
 * 
 * @author Mohit.3.Jain
 *
 */
@SpringBootTest
public class SimpleStockCalculationControllerTest {

	@Autowired
	SimpleStockCalculationController simpleStockCalculationController;
	
	@Autowired
	TradeController tradeController;

	// Building Application and throwing exception, we can send Response to caller
	// with Error Message.
	// Test Cases for Calculate Dividend start
	@Test
	public void calculateDividendWithWrongStockSymbol() {
		try {
			simpleStockCalculationController.calculateDividend("PP", 1D);
		} catch (Exception ex) {
			assertEquals("calculateDividend.stockSymbol: Invalid Stock symbol!!", ex.getMessage());
		}
	}

	@Test
	public void calculateDividendWhenStockSymbolIsNotInDB() {
		try {
			simpleStockCalculationController.calculateDividend("PPP", 1D);
		} catch (Exception ex) {
			assertEquals(ResponseConstants.INVALID_STOCK_SYMBOL.getMessage(), ex.getMessage());
		}
	}

	@Test
	public void calculateDividendWhenInCompatableType() {
		try {
			simpleStockCalculationController.calculateDividend("TST", 1D);
		} catch (Exception ex) {
			assertEquals(
					"No enum constant com.jpmorgan.simplestock.util.StockType.Test; nested exception is java.lang.IllegalArgumentException: No enum constant com.jpmorgan.simplestock.util.StockType.Test",
					ex.getMessage());
		}
	}

	@Test
	public void calculateDividendForCommonType() {
		ResponseEntity<CalculateDividendResponse> response = simpleStockCalculationController.calculateDividend("POP",
				1D);
		assertNotNull(response);
		assertEquals(1200, response.getBody().getCode());
		assertEquals(ResponseConstants.DIVIDEND_CALCULATION_SUCCESSFUL.getMessage(), response.getBody().getMessage());
		assertEquals(8.0, response.getBody().getDividend());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void calculateDividendForPreferred() {
		ResponseEntity<CalculateDividendResponse> response = simpleStockCalculationController.calculateDividend("GIN",
				10D);
		assertNotNull(response);
		assertEquals(1200, response.getBody().getCode());
		assertEquals(ResponseConstants.DIVIDEND_CALCULATION_SUCCESSFUL.getMessage(), response.getBody().getMessage());
		assertEquals(20.0, response.getBody().getDividend());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	// Test Cases for Calculate Dividend End

	// Building Application and throwing exception, we can send Response to caller with Error Message.
	// Test Cases for calculate PERatio start

	@Test
	public void calculatePERatioWithWrongStockSymbol() {
		try {
			simpleStockCalculationController.calculatePERatio("PP", 1D);
		} catch (Exception ex) {
			assertEquals("calculatePERatio.stockSymbol: Invalid Stock symbol!!", ex.getMessage());
		}
	}

	@Test
	public void calculatePERatioForCommonType() {
		ResponseEntity<CalculatePERatioResponse> response = simpleStockCalculationController.calculatePERatio("POP", 1D);
		assertNotNull(response);
		assertEquals(1201, response.getBody().getCode());
		assertEquals(ResponseConstants.PE_RATIO_CALCULATION_SUCCESSFUL.getMessage(), response.getBody().getMessage());
		assertEquals(0.125, response.getBody().getPeRatio());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void calculatePERatioForPreferred() {
		ResponseEntity<CalculatePERatioResponse> response = simpleStockCalculationController.calculatePERatio("GIN", 10D);
		assertNotNull(response);
		assertEquals(1201, response.getBody().getCode());
		assertEquals(ResponseConstants.PE_RATIO_CALCULATION_SUCCESSFUL.getMessage(), response.getBody().getMessage());
		assertEquals(0.5, response.getBody().getPeRatio());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	// Test Cases for Calculate PERatio End

	
	// Building Application and throwing exception, we can send Response to caller with Error Message.
	// Test Cases for calculate calculateVolumeWeightedStockPrice start

	@Test
	public void calculateVolumeWeightedStockPriceWithWrongStockSymbol() {
		try {
			simpleStockCalculationController.calculateVolumeWeightedStockPrice("PP");
		} catch (Exception ex) {
			assertEquals("calculateVolumeWeightedStockPrice.stockSymbol: Invalid Stock symbol!!", ex.getMessage());
		}
	}

	@Test
	public void calculateVolumeWeightedWhenNoTransaction() {
		ResponseEntity<CalculateVolumeWeightedPriceResponse> response = simpleStockCalculationController.calculateVolumeWeightedStockPrice("POP");
		assertNotNull(response);
		assertEquals(1202, response.getBody().getCode());
		assertEquals(ResponseConstants.VOLUME_WEIGHED_PRICE_CALCULATION_SUCCESSFUL.getMessage(), response.getBody().getMessage());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void calculateVolumeWeightedWhenTransaction() {
		ResponseEntity<TradeRecordMessage> tradeResponse = tradeController.recordTrade(getTradeObject());
		assertNotNull(tradeResponse);
		
		ResponseEntity<CalculateVolumeWeightedPriceResponse> response = simpleStockCalculationController.calculateVolumeWeightedStockPrice("POP");
		assertNotNull(response);
		assertEquals(1202, response.getBody().getCode());
		assertEquals(ResponseConstants.VOLUME_WEIGHED_PRICE_CALCULATION_SUCCESSFUL.getMessage(), response.getBody().getMessage());
		assertEquals(100.0, response.getBody().getVolumeWeighedPrice());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	// Test Cases for Calculate calculateVolumeWeightedStockPrice End
	
	@Test
	public void recordTradeInTradeController() {
		ResponseEntity<TradeRecordMessage> tradeResponse = tradeController.recordTrade(getTradeObject());
		assertNotNull(tradeResponse);
		assertEquals(1204, tradeResponse.getBody().getCode());
		assertEquals(ResponseConstants.TRADE_RECORD_SUCCESSFUL.getMessage(), tradeResponse.getBody().getMessage());
	}

	@Test
	public void getAllTradeController() {
		ResponseEntity<TradeRecordMessage> tradeResponse = tradeController.recordTrade(getTradeObject());
		assertNotNull(tradeResponse);
		ResponseEntity<GetAllTradesResponse> tradeRetriveResponse = tradeController.getAll();
		assertNotNull(tradeRetriveResponse);
		assertEquals(1026, tradeRetriveResponse.getBody().getCode());
		assertEquals(ResponseConstants.GET_ALL_TRADE_RECORDS_SUCCESSFULL.getMessage(), tradeRetriveResponse.getBody().getMessage());
		assertEquals(1, tradeRetriveResponse.getBody().getTrades().size());
		assertEquals(HttpStatus.OK, tradeRetriveResponse.getStatusCode());
		
	}

	private Trade getTradeObject() {
		Trade trade = new Trade();
		trade.setBuySellIndicator(TradeType.Buy);
		trade.setPrice(100F);
		trade.setQuantity(100);
		trade.setStockSymbol("POP");
		return trade;
	}
}
