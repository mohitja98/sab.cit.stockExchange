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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Trade Record Message bean class.
 * @author Mohit.3.Jain
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class TradeRecordMessage extends CodeMessageResponse {

	/**Record Created.*/
	private boolean recordCreated;
}
