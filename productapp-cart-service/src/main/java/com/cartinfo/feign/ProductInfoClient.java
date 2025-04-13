package com.cartinfo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cartinfo.model.Product;

@FeignClient(name = "PRODUCT-INFO")
public interface ProductInfoClient {
	
	@GetMapping("/info-service/v1/productInfo/productId/{productId}")
	Product  getProductById(@PathVariable int productId);
}
