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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jpmorgan.simplestock.util.TradeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Stock Trade entity.
 * 
 * @author Mohit.3.Jain
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "TRADE")
public class TradeEntity {

    /** Id Column (Primary id). */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    /** Stock Symbol. */
    @Column(name = "STOCK_SYMBOL")
    private String stockSymbol;

    /** Stock Price. */
    @Column(name = "PRICE")
    private Float price;

    /** Stock Quantity. */
    @Column(name = "QUANTITY")
    private Integer quantity;

    /** Stock Trade type. */
    @Column(name = "TRADER_TYPE")
    private TradeType tradeType;

}
