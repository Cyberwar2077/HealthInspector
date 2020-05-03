package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.cognizant.hi.controller"})
@ComponentScan({"com.cognizant.hi.service"})
@EnableJpaRepositories(basePackages="com.cognizant.hi.dao")
@EntityScan("com.cognizant.hi.entity")
public class HealthInspectorApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(HealthInspectorApplication.class, args);
	}

}
