/*
 * This code contains copyright information which is the proprietary property
 * of Mohit Jain Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * Mohit Jain Solutions.
 *
 * Copyright Mohit Jain 2022
 * Confidential. All rights reserved.
 */
package com.jpmorgan.simplestock.response;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

/**
 * Class for Calculate PE Ratio Response.
 * @author Mohit.3.Jain
 *
 */
public class CalculatePERatioResponseTest {

    /**
     * Setter and Getter test case,
     */
    @Test
    public void validateSettersAndGetters() {
          BeanTester beanTester = new BeanTester();
          beanTester.testBean(CalculatePERatioResponse.class);
    }
}
