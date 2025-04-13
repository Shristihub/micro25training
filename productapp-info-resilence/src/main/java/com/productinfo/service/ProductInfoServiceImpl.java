package com.productinfo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.productinfo.model.ProdType;
import com.productinfo.model.Failure;
import com.productinfo.model.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ProductInfoServiceImpl implements IProductInfoService {

	private RestTemplate restTemplate;
//	make an api call to catalog service
// get the base url
	private final String BASEURL = "http://PRODUCT-CATALOG/catalog-service/v1/products";
	
	public ProductInfoServiceImpl(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Override
	@CircuitBreaker(name = "INFO_SERVICE",fallbackMethod = "fallbackGetById")
	public ProdType getById(int productId) {
	//		http://localhost:8082/catalog-service/v1/products/productId/1
		String url = BASEURL.concat("/productId/") + productId;
		ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
		Product product = response.getBody();
		return product;
	}
	
	// same signature as the original method with exception as additional parameter
	public ProdType fallbackGetById(int productId,Exception exception) {
		return  new Failure("exception occured");
	}

	@Override
	@CircuitBreaker(name = "INFO_SERVICE",fallbackMethod = "fallbackGetAll")
	public List<Product> getAll() {
//		http://localhost:8082/catalog-service/v1/products
		ResponseEntity<List<Product>> response = (ResponseEntity) restTemplate.getForEntity(BASEURL, List.class);
		List<Product> products = response.getBody();
		System.out.println(response.getStatusCode().value());
		return products;
	}
	public List<Product> fallbackGetAll(Exception e) {
		return Arrays.asList(new Product());
	}

	@Override
	@CircuitBreaker(name = "INFO-SERVICE",fallbackMethod = "fallbackGetByCategory")
	public List<Product> getByCategory(String category) {
//		http://localhost:8082/catalog-service/v1/products/category/Sports
		String url = BASEURL.concat("/category/").concat(category);
		ResponseEntity<List<Product>> response = (ResponseEntity) restTemplate.getForEntity(url, List.class);
		List<Product> products = response.getBody();
		System.out.println(response.getStatusCode().value());
		return products;
	}
	public List<Product> fallbackGetByCategory(String category,Exception e) {
		return Arrays.asList(new Product());
	}

}
