/*
 * This code contains copyright information which is the proprietary property
 * of Mohit Jain Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * Mohit Jain Solutions.
 *
 * Copyright Mohit Jain 2022
 * Confidential. All rights reserved.
 */
package com.jpmorgan.simplestock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.google.common.base.Predicates;

/**
 * Main class for running spring boot application.
 * @author Mohit.3.Jain
 *
 */
@EnableSwagger2
@SpringBootApplication
public class SimplestockApplication {

	/**
	 * Main method for initiating spring boot application.
	 * @param args incoming arguments from the application if any.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SimplestockApplication.class, args);
	}
	
	/**Returns ApiInfo.
     * 
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Stock Exchange| Southbound REST APIs | Test Service")
                .contact(new Contact("Test Team", "www.test.aero", "xyz@test.aero"))
                .build();
    }
    /**Returns Docket.
     * 
     * @return Docket
     */
    @Bean
    public Docket configApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error"))) // Exclude Spring error controllers
                .build();
    }
}
