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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.jpmorgan.simplestock.entities.StockData;

@TestInstance(Lifecycle.PER_CLASS)
public class SimpleStockUtilTest {
	
	/**Creating Stock Data bean.*/
	private StockData stockData;
	
	/**
	 * setup method which execute before all the test cases.
	 */
    @BeforeAll
	public void setup() {
    	stockData = new StockData();
    	stockData.setFixedDividend(1.0D);
    	stockData.setParValue(1.0D);
    	stockData.setLastDividend(1D);
	}
    
    /**Executing Afater every test case.*/
    @AfterAll
	public void after() {
    	stockData = null;
	}

    /**
     * Test method for calculate preferred Dividend.
     */
    @Test
    public void calculatePreferredDividend() {
    	assertEquals(1.0, SimpleStockUtil.calculatePreferredDividend(stockData, 1.0D));  	
    }
    
    /**
     * Test Method for calculate common dividend.
     */
    @Test
    public void calculateCommonDividend() {
    	assertEquals(1.0, SimpleStockUtil.calculatePreferredDividend(stockData, 1.0D));  	
    }

    /**
     *  Test Method for calculate PE Ratio.
     */
    @Test
    public void calculatePERatio() {
    	assertEquals(1.0, SimpleStockUtil.calculatePERatio(1D, 1.0D));  	
    }
}
