package com.asb.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients//enable component scanning for interfaces annotated with @FeignClient
@EnableCaching
@EnableTransactionManagement
public class SpringBootJpaCrudExampleApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootJpaCrudExampleApplication.class);
	public static void main(String[] args) {
		LOGGER.info("hello world");
		SpringApplication.run(SpringBootJpaCrudExampleApplication.class, args);
	}


}
