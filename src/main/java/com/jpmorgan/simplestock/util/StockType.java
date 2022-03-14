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
 * Enum class for stock type.
 * @author Mohit.3.Jain
 *
 */
public enum StockType {

    /**Stock type as common.*/
    Common("Common"), 
    
    /**Stock type as preferred.*/
    Preferred("Preferred");

    /**Stock Type*/
    String type;
    
    /**
     * Stock type constructor.
     * @param type incoming type.
     */
    StockType(final String type) {
        this.type = type;
    }

    /**
     * Get value for stock type enum.
     * @param value incoming value.
     * @return Stock enum.
     */
    public static StockType fromValue(final String value) {
        for (StockType b : StockType.values()) {
            if (b.type.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
