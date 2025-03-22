package com.gatewayapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductappGatewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappGatewayApiApplication.class, args);
	}
	
	@Bean
	public RouteLocator customRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("catalogService",p->p.path("/catalog-service/**").uri("lb://PRODUCT-CATALOG"))
				.route("inventoryService",p->p.path("/inventory-service/**").uri("lb://PRODUCT-INVENTORY"))
				.route("infoService",p->p.path("/info-service/**").uri("lb://PRODUCT-INFO"))
				.build();
	}

}
