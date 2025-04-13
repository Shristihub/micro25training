package com.userinfo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductappUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappUserServiceApplication.class, args);
	}
	@Bean
	ModelMapper mapper() {
		return new ModelMapper();
	}

}
