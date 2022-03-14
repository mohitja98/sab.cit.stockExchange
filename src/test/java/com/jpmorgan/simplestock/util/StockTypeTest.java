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
 * 
 * @author Mohit.3.Jain
 *
 */
public class StockTypeTest {
	
	@Test
	public void stockTypeEnumCount() {
		StockType[] count = StockType.values();
		assertEquals(2, count.length);
	}

	@Test
	public void stockTypeEnumValue() {
		 assertEquals(StockType.Common , StockType.fromValue("Common"));
		 assertEquals(StockType.Preferred , StockType.fromValue("Preferred"));
	}

	@Test
	public void stockTypeEnumValueNotPersentInEnum() {
		 try {
			  StockType.fromValue("common");
		 } catch (IllegalArgumentException ex) {
			 assertEquals("Unexpected value 'common'", ex.getMessage());
		 }
	}

}
