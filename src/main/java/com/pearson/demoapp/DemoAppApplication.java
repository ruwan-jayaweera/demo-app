package com.pearson.demoapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAppApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}

}
