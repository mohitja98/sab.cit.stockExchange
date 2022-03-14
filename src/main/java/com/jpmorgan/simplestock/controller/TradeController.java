/*
 * This code contains copyright information which is the proprietary property
 * of Mohit Jain Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * Mohit Jain Solutions.
 *
 * Copyright Mohit Jain 2022
 * Confidential. All rights reserved.
 */
package com.jpmorgan.simplestock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpmorgan.simplestock.request.Trade;
import com.jpmorgan.simplestock.response.GetAllTradesResponse;
import com.jpmorgan.simplestock.response.TradeRecordMessage;
import com.jpmorgan.simplestock.service.TradeService;

/**
 * Trade Controller.
 * @author Mohit.3.Jain
 *
 */
@RestController
@RequestMapping(path = "/trade")
@Validated
public class TradeController {

	@Autowired
	TradeService tradeService;

	@PostMapping("/")
	public ResponseEntity<TradeRecordMessage> recordTrade(@RequestBody @Valid final Trade trade) {
		return ResponseEntity.ok(tradeService.recordTrade(trade));
	}
	
	@GetMapping("/")
	public ResponseEntity<GetAllTradesResponse> getAll() {
		return ResponseEntity.ok(tradeService.retrieveAll());
	}
}
