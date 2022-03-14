/*
 * This code contains copyright information which is the proprietary property
 * of Mohit Jain Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * Mohit Jain Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2020
 * Confidential. All rights reserved.
 */
package com.jpmorgan.simplestock.constants;

/**
 * Response enum class.
 * @author Mohit.3.Jain
 *
 */
public enum ResponseConstants {
	/**DIVIDEND_CALCULATION_SUCCESSFUL*/
	DIVIDEND_CALCULATION_SUCCESSFUL(1200, "Dividend Calculated successfully"),
	/**PE_RATIO_CALCULATION_SUCCESSFUL*/
	PE_RATIO_CALCULATION_SUCCESSFUL(1201, "PE Ratio calculated successfully"),
	/**VOLUME_WEIGHED_PRICE_CALCULATION_SUCCESSFUL*/
	VOLUME_WEIGHED_PRICE_CALCULATION_SUCCESSFUL(1202, "Volume weighted price calculated successfully"),
	/**GEOMETRIC_MEAN_CALCULATION_SUCCESSFUL*/
	GEOMETRIC_MEAN_CALCULATION_SUCCESSFUL(1203, "Geometric mean calculated successfully"),
	/**TRADE_RECORD_SUCCESSFUL*/
	TRADE_RECORD_SUCCESSFUL(1204, "Trade recorded successfully"),
	/**GET_ALL_STOCK_DATA_SUCCESSFULL*/
	GET_ALL_STOCK_DATA_SUCCESSFULL(1025, "Fetching All the stock data was successful"),
	/**GET_ALL_TRADE_RECORDS_SUCCESSFULL*/
	GET_ALL_TRADE_RECORDS_SUCCESSFULL(1026, "Fetching All the trade records successful"),
	/**NO_RECORDS_FOUND*/
	NO_RECORDS_FOUND(1404, "No Records found"),
	/**INVALID_STOCK_SYMBOL*/
	INVALID_STOCK_SYMBOL(1405, "Invlaid Stock Symbol!!"),
	/**DIVIDEND_YEILDED_ZERO_CANT_CALCULATE_PE_RATIO*/
	DIVIDEND_YEILDED_ZERO_CANT_CALCULATE_PE_RATIO(1409, "Dividend yeilded was 0. Hence can't calculate PE Ratio"),
	/**IN_COMPATIBLE_STOCK_TYPE*/
	IN_COMPATIBLE_STOCK_TYPE(1500, "In Compatible stock type!!");
	
	/**
	 * Response constructor.
	 * @param code incoming code.
	 * @param message incoming message.
	 */
	ResponseConstants(final Integer code, final String message) {
		this.code = code;
		this.message = message;
	}

	/**Integer Code.*/
	Integer code;
	
	/**Response Message.*/
	String message;

	/**
	 * Getter method for code.
	 * @return code.
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * Setter method for code.
	 * @param code incoming code.
	 */
	public void setCode(final Integer code) {
		this.code = code;
	}

	/**
	 * Geeter method for message.
	 * @return message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter method for Message.
	 * @param message incoming message.
	 */
	public void setMessage(final String message) {
		this.message = message;
	}
 
	/**
	 * Get enum from code.
	 * @param code incoming code.
	 * @return enum.
	 */
	public static ResponseConstants fromCode(final String code) {
		for (ResponseConstants b : ResponseConstants.values()) {
			if (b.code.equals(code)) {
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + code + "'");
	}
	
}