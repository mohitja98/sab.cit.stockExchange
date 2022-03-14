/*
 * This code contains copyright information which is the proprietary property
 * of Mohit Jain Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * Mohit Jain Solutions.
 *
 * Copyright Mohit Jain 2022
 * Confidential. All rights reserved.
 */
package com.jpmorgan.simplestock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmorgan.simplestock.constants.ResponseConstants;
import com.jpmorgan.simplestock.dao.StockDataRepository;
import com.jpmorgan.simplestock.entities.StockData;
import com.jpmorgan.simplestock.exception.ServiceException;
import com.jpmorgan.simplestock.response.CalculateDividendResponse;
import com.jpmorgan.simplestock.response.CalculatePERatioResponse;
import com.jpmorgan.simplestock.response.GetAllStockDataResponse;
import com.jpmorgan.simplestock.util.SimpleStockUtil;

/**
 * Simple stock service class.
 * 
 * @author Mohit.3.Jain
 *
 */
@Service("dbImplementation")
public class SimpleStockServiceImpl implements SimpleStockService {

	/** Stock Data repository. */
	@Autowired
	StockDataRepository repository;

	@Override
	public CalculateDividendResponse calculateDividend(final String stockSymbol, final Double price) throws ServiceException {
		Optional<StockData> optionalStock = repository.findById(stockSymbol);
		if (optionalStock.isEmpty()) {
			throw new ServiceException(ResponseConstants.INVALID_STOCK_SYMBOL);
		}
		StockData stock = optionalStock.get();
		switch (stock.getType()) {
		case Common:
			return CalculateDividendResponse.builder().dividend(SimpleStockUtil.calculateCommonDividend(stock, price))
					.code(ResponseConstants.DIVIDEND_CALCULATION_SUCCESSFUL.getCode())
					.message(ResponseConstants.DIVIDEND_CALCULATION_SUCCESSFUL.getMessage()).build();
		case Preferred:
			return CalculateDividendResponse.builder()
					.dividend(SimpleStockUtil.calculatePreferredDividend(stock, price))
					.code(ResponseConstants.DIVIDEND_CALCULATION_SUCCESSFUL.getCode())
					.message(ResponseConstants.DIVIDEND_CALCULATION_SUCCESSFUL.getMessage()).build();
		default:
			// This wont happen anytime but just a readability sake!!!
			throw new ServiceException(ResponseConstants.IN_COMPATIBLE_STOCK_TYPE);
		}
	}

	@Override
	public CalculatePERatioResponse calculatePERatio(final String stockSymbol, final Double price) throws ServiceException {
		CalculateDividendResponse dividend = calculateDividend(stockSymbol, price);
		if (dividend.getDividend() != null && dividend.getDividend() != 0) {
			return CalculatePERatioResponse.builder()
					.peRatio(SimpleStockUtil.calculatePERatio(price, dividend.getDividend()))
					.code(ResponseConstants.PE_RATIO_CALCULATION_SUCCESSFUL.getCode())
					.message(ResponseConstants.PE_RATIO_CALCULATION_SUCCESSFUL.getMessage()).build();
		} else {
			throw new ServiceException(ResponseConstants.DIVIDEND_YEILDED_ZERO_CANT_CALCULATE_PE_RATIO);
		}
	}

	@Override
	public GetAllStockDataResponse getAllStocks() {
		return GetAllStockDataResponse.builder().stocks(repository.findAll())
				.code(ResponseConstants.GET_ALL_STOCK_DATA_SUCCESSFULL.getCode())
				.message(ResponseConstants.GET_ALL_STOCK_DATA_SUCCESSFULL.getMessage()).build();
	}
}
