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

/**
 * Enum class for trade type.
 * @author Mohit.3.Jain
 *
 */
public enum TradeType {

	/**Trade type Buy.*/
	Buy("Buy"),
	
	/**Trade type sell.*/
	Sell("Sell");
	
	/**Trade type.*/
	private String type;
	
	/**
	 * Constructor of Trade type.
	 * @param type incoming trade type.
	 */
	TradeType(final String type) {
		this.type = type;
	}

	/**
	 * Metod for getting enum value.
	 * @param value incoming tade type.
	 * @return object of Enum.
	 */
	public static TradeType fromValue(final String value) {
		for (TradeType b : TradeType.values()) {
			if (b.type.equals(value)) {
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + value + "'");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
