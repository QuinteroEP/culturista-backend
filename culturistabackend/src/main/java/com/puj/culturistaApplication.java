package com.puj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.puj.entity.Destiny;


@SpringBootApplication
public class culturistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(culturistaApplication.class, args);
	}

	@Bean
	public Destiny Monserrate() {
		return new Destiny(
			"Monserrate",
			"Un lugar turístico de Bogotá",
			"https://www.google.com",
			"Bogotá",
			"Turismo",
			"2021-10-10"
		);
	}

}