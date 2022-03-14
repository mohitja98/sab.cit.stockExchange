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

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.jpmorgan.simplestock.entities.TradeEntity;
import com.jpmorgan.simplestock.request.Trade;

/**
 * Class for Trade to Trader Entity
 * @author Mohit.3.Jain
 *
 */
public class ConvertIFaceTradeToTraderEntity {

    public static TradeEntity convertToTradeEntity(final Trade trade){ 
        return TradeEntity.builder()
                            .price(trade.getPrice())
                            .stockSymbol(trade.getStockSymbol())
                            .quantity(trade.getQuantity())
                            .tradeType(TradeType.fromValue(trade.getBuySellIndicator().name()))
                            .build();
    }

    public static List<Trade> convertToTradeInterface(final List<TradeEntity> tradeEntity){
        return tradeEntity.stream()
                            .map(te -> convertToTradeInterface(te))
                            .collect(Collectors.toList());
    }
    
    public static Trade convertToTradeInterface(final TradeEntity trade){ 
        return Trade.builder()
                            .stockSymbol(trade.getStockSymbol())
                            .quantity(trade.getQuantity())
                            .buySellIndicator(com.jpmorgan.simplestock.request.TradeType.fromValue(trade.getTradeType().name()))
                            .build();
    }

}
