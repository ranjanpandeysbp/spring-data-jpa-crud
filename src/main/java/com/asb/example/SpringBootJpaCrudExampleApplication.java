package com.asb.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootJpaCrudExampleApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootJpaCrudExampleApplication.class);
	public static void main(String[] args) {
		LOGGER.info("hello world");
		SpringApplication.run(SpringBootJpaCrudExampleApplication.class, args);
	}


}
