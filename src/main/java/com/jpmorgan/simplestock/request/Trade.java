/*
 * This code contains copyright information which is the proprietary property
 * of Mohit Jain Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * Mohit Jain Solutions.
 *
 * Copyright Mohit Jain 2022
 * Confidential. All rights reserved.
 */
package com.jpmorgan.simplestock.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.jpmorgan.simplestock.constants.ApplicationConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Trade Bean class.
 * 
 * @author Mohit.3.Jain
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Validated
public class Trade {

    /** Price with not null validation. */
    @NotNull(message = ApplicationConstants.PRICE_FIELD_IS_REQUIRED)
    private Float price;

    /** Quantity with not null validation. */
    @NotNull(message = ApplicationConstants.QUANTITY_IS_REQUIRED)
    @Min(value = 1, message = ApplicationConstants.QUANTITY_LESS_THAN_1_ERROR)
    private Integer quantity;

    /** Buy Seller indicator with not null validation. */
    @NotNull(message = ApplicationConstants.TRADE_TYPE_REQUIRED)
    private TradeType buySellIndicator;

    /** Stock Symbol with validation. */
    @Size(min = 3, max = 3, message = ApplicationConstants.INVALID_STOCK_SYMBOL)
    @NotBlank(message = ApplicationConstants.STOCK_SYMBOL_IS_REQUIRED)
    private String stockSymbol;

}
