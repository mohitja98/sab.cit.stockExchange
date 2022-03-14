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

import java.util.List;

import com.jpmorgan.simplestock.entities.StockData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Response class for Get
 * @author Mohit.3.Jain
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GetAllStockDataResponse extends CodeMessageResponse {

	/**List of stock Data.*/
	private List<StockData> stocks; 
}
