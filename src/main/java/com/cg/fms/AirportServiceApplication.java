package com.cg.fms;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
public class AirportServiceApplication {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.logger(AirportServiceApplication.class);
		logger.info("Starting Application.");
		SpringApplication.run(AirportServiceApplication.class, args);
		logger.info("Application Running.");
	}

}
