package com.naughtyzombie.boilerplate.springreactboilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages =  "com.naughtyzombie.boilerplate.springreactboilerplate.repository")
@ComponentScan(basePackages =  "com.naughtyzombie.boilerplate.springreactboilerplate.model")
@ComponentScan(basePackages =  "com.naughtyzombie.boilerplate.springreactboilerplate.resource")
@ComponentScan(basePackages =  "com.naughtyzombie.boilerplate.springreactboilerplate.service")
@ComponentScan(basePackages =  "com.naughtyzombie.boilerplate.springreactboilerplate.config")
public class SpringReactBoilerplateApplication {

	public static final Logger logger = LoggerFactory.getLogger(SpringReactBoilerplateApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringReactBoilerplateApplication.class, args);
	}
}
