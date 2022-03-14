/*
 * This code contains copyright information which is the proprietary property
 * of Mohit Jain Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * Mohit Jain Solutions.
 *
 * Copyright Mohit Jain 2022
 * Confidential. All rights reserved.
 */
package com.jpmorgan.simplestock.entities;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

/**
 * Test class for stock data.
 * @author Mohit.3.Jain
 *
 */
public class StockDataTest {

    /**
     * Setter and Getter test case,
     */
    @Test
    public void validateSettersAndGetters() {
          BeanTester beanTester = new BeanTester();
          beanTester.testBean(StockData.class);
    }
}
