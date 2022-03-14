package com.jpmorgan.simplestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmorgan.simplestock.constants.ResponseConstants;
import com.jpmorgan.simplestock.dao.TradeRepository;
import com.jpmorgan.simplestock.entities.TradeEntity;
import com.jpmorgan.simplestock.request.Trade;
import com.jpmorgan.simplestock.response.CalculateGeometricMeanResponse;
import com.jpmorgan.simplestock.response.CalculateVolumeWeightedPriceResponse;
import com.jpmorgan.simplestock.response.GetAllTradesResponse;
import com.jpmorgan.simplestock.response.TradeRecordMessage;
import com.jpmorgan.simplestock.util.ConvertIFaceTradeToTraderEntity;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	TradeRepository tradeRepository;
	
	@Override
	public TradeRecordMessage recordTrade(Trade trade) {
		tradeRepository.save(ConvertIFaceTradeToTraderEntity.convertToTradeEntity(trade));
		return TradeRecordMessage.builder()
								 .recordCreated(true)
								 .code(ResponseConstants.TRADE_RECORD_SUCCESSFUL.getCode())
								 .message(ResponseConstants.TRADE_RECORD_SUCCESSFUL.getMessage())
								 .build();
	}

	@Override
	public GetAllTradesResponse retrieveAll() {
		return GetAllTradesResponse.builder()
								   .trades(ConvertIFaceTradeToTraderEntity.convertToTradeInterface(tradeRepository.findAll()))
								   .code(ResponseConstants.GET_ALL_TRADE_RECORDS_SUCCESSFULL.getCode())
								   .message(ResponseConstants.GET_ALL_TRADE_RECORDS_SUCCESSFULL.getMessage())
								   .build();
	}

	@Override
	public CalculateVolumeWeightedPriceResponse calculateVolumeWeightedStockPrice(String stockSymbol) {
		List<TradeEntity> tradesInLastFifteenMinutes = tradeRepository.getAllTrades(stockSymbol);
		Double summationOfTradedPriceAndQuantity = 0D;
		Double summationQuantity = 0D;
		for (TradeEntity trade : tradesInLastFifteenMinutes) {
			summationOfTradedPriceAndQuantity += trade.getPrice() * trade.getQuantity();
			summationQuantity += trade.getQuantity();
		}
		return CalculateVolumeWeightedPriceResponse.builder()
													.volumeWeighedPrice(summationOfTradedPriceAndQuantity / summationQuantity)
													.code(ResponseConstants.VOLUME_WEIGHED_PRICE_CALCULATION_SUCCESSFUL.getCode())
													.message(ResponseConstants.VOLUME_WEIGHED_PRICE_CALCULATION_SUCCESSFUL.getMessage())
													.build();
	}

	@Override
	public CalculateGeometricMeanResponse calculateGeometricMean() {
		List<TradeEntity> trades = tradeRepository.findAll();
		Double proudctOfAllPrices = trades.stream().mapToDouble(trade -> trade.getPrice()).reduce(1.0, (a, b) -> a * b);
		return CalculateGeometricMeanResponse.builder()
											 .geometricMean(Math.pow(proudctOfAllPrices, 1.0 / trades.size()))
											 .code(ResponseConstants.GEOMETRIC_MEAN_CALCULATION_SUCCESSFUL.getCode())
											 .message(ResponseConstants.GEOMETRIC_MEAN_CALCULATION_SUCCESSFUL.getMessage())
											 .build();
	}
}
