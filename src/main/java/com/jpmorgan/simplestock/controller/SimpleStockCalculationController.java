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

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpmorgan.simplestock.aspects.LogTime;
import com.jpmorgan.simplestock.constants.ApplicationConstants;
import com.jpmorgan.simplestock.response.CalculateDividendResponse;
import com.jpmorgan.simplestock.response.CalculateGeometricMeanResponse;
import com.jpmorgan.simplestock.response.CalculatePERatioResponse;
import com.jpmorgan.simplestock.response.CalculateVolumeWeightedPriceResponse;
import com.jpmorgan.simplestock.response.GetAllStockDataResponse;
import com.jpmorgan.simplestock.service.SimpleStockService;
import com.jpmorgan.simplestock.service.TradeService;

/**
 * Rest controller for Stock Calculation.
 * @author Mohit.3.Jain
 *
 */
@RestController
@RequestMapping(path = "/calculate")
@Validated
public class SimpleStockCalculationController {

	/**Service Class for Stock.*/
	@Autowired
	SimpleStockService stockService;

	/**Trade Service class.*/
	@Autowired
	TradeService tradeService;
	
	/**
	 * Rest end point for getting all Data available in DB.
	 * @return 
	 */
	@LogTime
	@GetMapping(value = "/all")
	public ResponseEntity<GetAllStockDataResponse> all() {
		return ResponseEntity.ok(stockService.getAllStocks());
	}
	
	
	@LogTime
	@GetMapping(value = "/dividend/{stockSymbol}")
	public ResponseEntity<CalculateDividendResponse> calculateDividend(@PathVariable(name = ApplicationConstants.STOCK_SYMBOL) 
									@Size(min = 3, max = 3, message = ApplicationConstants.INVALID_STOCK_SYMBOL) final String stockSymbol
									, @RequestParam(name = ApplicationConstants.PRICE) Double price) {
		return ResponseEntity.ok(stockService.calculateDividend(stockSymbol, price));
	}
	
	@LogTime
	@GetMapping("/pe-ratio/{stockSymbol}")
	public ResponseEntity<CalculatePERatioResponse> calculatePERatio(@PathVariable(name = ApplicationConstants.STOCK_SYMBOL) 
	 								  @Size(min = 3, max = 3, message = ApplicationConstants.INVALID_STOCK_SYMBOL) final String stockSymbol
									, @RequestParam("price") Double price) {
		return ResponseEntity.ok(stockService.calculatePERatio(stockSymbol, price));
	}
	
	@LogTime
	@GetMapping("/GBCE/")
	public ResponseEntity<CalculateGeometricMeanResponse> calculateGBCE() {
		return ResponseEntity.ok(tradeService.calculateGeometricMean());
	}
	
	@LogTime
	@GetMapping("/vw-stock-price/{stockSymbol}")
	public ResponseEntity<CalculateVolumeWeightedPriceResponse> calculateVolumeWeightedStockPrice(@PathVariable(name = ApplicationConstants.STOCK_SYMBOL) 
													@Size(min = 3, max = 3, message = ApplicationConstants.INVALID_STOCK_SYMBOL) final String stockSymbol) {
		return ResponseEntity.ok().body(tradeService.calculateVolumeWeightedStockPrice(stockSymbol));
	}
}
