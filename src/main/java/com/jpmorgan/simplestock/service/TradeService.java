package com.jpmorgan.simplestock.service;

import com.jpmorgan.simplestock.request.Trade;
import com.jpmorgan.simplestock.response.CalculateGeometricMeanResponse;
import com.jpmorgan.simplestock.response.CalculateVolumeWeightedPriceResponse;
import com.jpmorgan.simplestock.response.GetAllTradesResponse;
import com.jpmorgan.simplestock.response.TradeRecordMessage;

public interface TradeService {

	
	/**
	 * Creates a record / entry of a trade
	 * @param trade - Instance of trade type which is exposed as interface to external world
	 * @return
	 */
	public TradeRecordMessage recordTrade(final Trade trade);

	/**
	 * Miscellaneous method which returns all the records of trades 
	 * @return GetAllTradesResponse
	 */
	public GetAllTradesResponse retrieveAll();

	/**
	 * Returns volume weighted prices for the stock which we are looking for.
	 * 
	 * 		∑ 𝑇𝑟𝑎𝑑𝑒𝑑 𝑃𝑟𝑖𝑐𝑒𝑖 × 𝑄𝑢𝑎𝑛𝑡𝑖𝑡𝑦 / ∑ 𝑄𝑢𝑎𝑛𝑡𝑖𝑡𝑦
	 * 
	 * @param stockSymbol - symbol / code of the stock
	 * @return CalculateVolumeWeightedPriceResponse - Instance of this type with volume weighted price packed in it.
	 */
	public CalculateVolumeWeightedPriceResponse calculateVolumeWeightedStockPrice(String stockSymbol);
	
	/**
	 * Calculates GBCE / Geometric mean 
	 * nth root (p1.p2.p3...pn) where p1, p2 etc are the prices at which each trade took place.
	 * 
	 * @return CalculateGeometricMeanResponse 
	 */
	public CalculateGeometricMeanResponse calculateGeometricMean();
}
