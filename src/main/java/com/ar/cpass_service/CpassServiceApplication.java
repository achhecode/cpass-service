package com.ar.cpass_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ar.cpass_service.repository")
@EntityScan(basePackages = "com.ar.cpass_service.entity")
public class CpassServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpassServiceApplication.class, args);
	}

}
