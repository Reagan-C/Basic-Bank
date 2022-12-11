package com.finservice.basicbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class BasicBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicBankApplication.class, args);
	}

}
