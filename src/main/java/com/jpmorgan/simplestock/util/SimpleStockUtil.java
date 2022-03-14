/*
 * This code contains copyright information which is the proprietary property
 * of Mohit Jain Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * Mohit Jain Solutions.
 *
 * Copyright Mohit Jain 2022
 * Confidential. All rights reserved.
 */
package com.jpmorgan.simplestock.util;

import com.jpmorgan.simplestock.entities.StockData;

/**
 * Utility Class for calulation.
 * @author Mohit.3.Jain
 *
 */
public class SimpleStockUtil {

	/**
	 * Calculates Dividend for Preferred stock type
	 * formula = (FixedDividend * ParValue) / price
	 * @param stock - Stock data
	 * @param price - price for which dividend needs to be calculated
	 * @return Float
	 */
	public static Double calculatePreferredDividend(final StockData stock, final Double price) {
		return (stock.getFixedDividend() * stock.getParValue()) / price;
	}

	/**
	 * Calculates dividend for Common stock type
	 * formula => LastDividend / price
	 * @param stock - Stock data
	 * @param price - price for which dividend needs to be calculated.
	 * @return Float calculated dividend.
	 */
	public static Double calculateCommonDividend(final StockData stock, final Double price) {
		return stock.getLastDividend() / price;
	}

	/**
	 * Calculates PE Ratio.
	 * @param price incoming price value.
	 * @param dividend incoming dividend value.
	 * @return calculated PE Ratio.
	 */
	public static Double calculatePERatio(final Double price, final Double dividend) {
		return price / dividend;
	}
}
