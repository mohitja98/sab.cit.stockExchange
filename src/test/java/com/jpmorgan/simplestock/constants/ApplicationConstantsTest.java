/*
 * This code contains copyright information which is the proprietary property
 * of Mohit Jain Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * Mohit Jain Solutions.
 *
 * Copyright Mohit Jain 2022
 * Confidential. All rights reserved.
 */
package com.jpmorgan.simplestock.constants;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test class for Application Constrants.
 * @author Mohit.3.Jain
 *
 */
public class ApplicationConstantsTest {

	 @Test
	 public void validateConstantValues() {
         assertEquals("Invalid Stock symbol!!", ApplicationConstants.INVALID_STOCK_SYMBOL);
         assertEquals("stockSymbol", ApplicationConstants.STOCK_SYMBOL);
         assertEquals("price", ApplicationConstants.PRICE);
         assertEquals("Trade Type is required.", ApplicationConstants.TRADE_TYPE_REQUIRED);
         assertEquals("Quantity can not be less than 1.", ApplicationConstants.QUANTITY_LESS_THAN_1_ERROR);
         assertEquals("Quantity is required", ApplicationConstants.QUANTITY_IS_REQUIRED);
         assertEquals("Price is required.", ApplicationConstants.PRICE_FIELD_IS_REQUIRED);
         assertEquals("Stock Symbol is required.", ApplicationConstants.STOCK_SYMBOL_IS_REQUIRED);
	 }
}
