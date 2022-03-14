/*
 * This code contains copyright information which is the proprietary property
 * of Mohit Jain Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * Mohit Jain Solutions.
 *
 * Copyright Mohit Jain 2022
 * Confidential. All rights reserved.
 */
package com.jpmorgan.simplestock.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

/**
 * Creating Aspect Class for lokking point of view.
 * @author Mohit.3.Jain
 *
 */
@Aspect
@Component
public class CrosscuttingConcerns {

	/**The Logger.*/
	Logger logger = LoggerFactory.getLogger(CrosscuttingConcerns.class);
	
	/**
	 * Method for log time.
	 * @param joinPoint incoming joint point.
	 * @return object of logs.
	 * @throws Throwable if any error.
	 */
	@Around("@annotation(com.jpmorgan.simplestock.aspects.LogTime)")
	public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
	    long start = System.currentTimeMillis();
	    try {
	        logger.info("============ Aspect ====>");
	        logger.info("Calling "+joinPoint.getTarget().getClass().getSimpleName()+"."+joinPoint.getSignature().getName());
	        Object proceed = joinPoint.proceed();
    		return proceed;
	    } catch (Exception e) {
	        logger.error("Catching exception in logtime method ", e);
	        throw e;
        } finally {
            logger.info("************** Done calling  "+joinPoint.getSignature().getName());
            logger.info("Time for execution "+(System.currentTimeMillis() - start)+"ms");
            logger.info("<============ Aspect ====");
        }
	}
	
}
