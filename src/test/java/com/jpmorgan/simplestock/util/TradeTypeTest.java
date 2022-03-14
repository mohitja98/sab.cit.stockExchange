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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Enum Test for Trade type.
 * @author Mohit.3.Jain
 *
 */
public class TradeTypeTest {

	@Test
	public void tradeTypeEnumCount() {
		TradeType[] count = TradeType.values();
		assertEquals(2, count.length);
	}

	@Test
	public void tradeTypeEnumValue() {
		 assertEquals(TradeType.Buy , TradeType.fromValue("Buy"));
		 assertEquals(TradeType.Sell , TradeType.fromValue("Sell"));
	}

	@Test
	public void tradeTypeEnumValueNotPersentInEnum() {
		 try {
			  StockType.fromValue("buy");
		 } catch (IllegalArgumentException ex) {
			 assertEquals("Unexpected value 'buy'", ex.getMessage());
		 }
	}
}
