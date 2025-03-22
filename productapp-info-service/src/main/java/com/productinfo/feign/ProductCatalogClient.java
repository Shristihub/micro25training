package com.productinfo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.productinfo.model.Product;

@FeignClient(name="PRODUCT-CATALOG")
public interface ProductCatalogClient {
	
	// copy the rest apis to which you want to connect
	//add the url pattern of the restendpoints of the microservice
	
//	http://localhost:8082/catalog-service/v1/products/productId/1
	@GetMapping("/catalog-service/v1/products/productId/{productId}")
	Product getById(@PathVariable int productId);
	
//	http://localhost:8082/catalog-service/v1/products/category/Electronics
	@GetMapping("/catalog-service/v1/products/category/{category}")
	List<Product> getByCategory(@PathVariable String category);
	
//	http://localhost:8082/catalog-service/v1/products
	@GetMapping("/catalog-service/v1/products")
	List<Product> getAll();
	
}









