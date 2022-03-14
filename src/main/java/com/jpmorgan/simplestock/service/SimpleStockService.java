package com.jpmorgan.simplestock.service;

import com.jpmorgan.simplestock.exception.ServiceException;
import com.jpmorgan.simplestock.response.CalculateDividendResponse;
import com.jpmorgan.simplestock.response.CalculatePERatioResponse;
import com.jpmorgan.simplestock.response.GetAllStockDataResponse;

public interface SimpleStockService {

	/**
	 * Calculates Dividend based on type Stock[Common, Referred] If the stock type
	 * is Common then lastDividend / price is what will be applied. If the stock
	 * type is referred then (fixedDividend * parValue) / price is applied.
	 * 
	 * @param stockSymbol - symbol / code of the stock
	 * @param price       - Current price of the stock
	 * @return CalculateDividendResponse - Returns calculated dividend and returns
	 *         in the response
	 */
	CalculateDividendResponse calculateDividend(String stockSymbol, Double price) throws ServiceException;

	/**
	 * Calculates PE Ratio of a stock for a given price.
	 * 
	 * @param stockSymbol - symbol / code of the stock
	 * @param price       - Current price of the stock
	 * @return CalculatePERatioResponse - Returns instance of
	 *         CalculatePERatioResponse packed with calculated pe-ratio in it
	 */
	CalculatePERatioResponse calculatePERatio(String stockSymbol, Double price) throws ServiceException;

	/**
	 * Covinience method created which returns the all the stocks in DB
	 * @return GetAllStockDataResponse - Returns GetAllStockDataResponse containing all the stocks data in it. 
	 */
	GetAllStockDataResponse getAllStocks() throws ServiceException;

}
