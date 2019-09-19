package com.qa.account.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qa.account.example.util.NumberGenerator;

@Configuration
public class AppConfig {

	@Bean
	public NumberGenerator numberGenerator() {
		return new NumberGenerator(6);
	}
}
