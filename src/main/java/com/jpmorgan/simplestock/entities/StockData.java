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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jpmorgan.simplestock.util.StockType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Stock Data Bean class.
 * 
 * @author Mohit.3.Jain
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "STOCK_DATA")
@Entity
public class StockData {

    /** ID column. */
    @Id
    @Column(name = "STOCK_SYMBOL")
    private String stockSymbol;

    /** Stock type column. */
    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private StockType type;

    /** Last Dividend column. */
    @Column(name = "LAST_DIVIDEND")
    private Double lastDividend;

    /** Fixed Dividend column. */
    @Column(name = "FIXED_DIVIDEND")
    private Double fixedDividend;

    /** Per value column class. */
    @Column(name = "PAR_VALUE")
    private Double parValue;

}