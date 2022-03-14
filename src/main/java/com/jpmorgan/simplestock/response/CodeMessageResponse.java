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
 * Code message class, generic for all other responses.
 * @author Mohit.3.Jain
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CodeMessageResponse {

	/**Response Code.*/
	private Integer code;
	
	/**Response Message.*/
	private String message;
}
