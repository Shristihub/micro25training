package com.cartinfo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ProductappCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappCartServiceApplication.class, args);
	}
	
	@Bean
	ModelMapper mapper() {
		return new ModelMapper();
	}
}
