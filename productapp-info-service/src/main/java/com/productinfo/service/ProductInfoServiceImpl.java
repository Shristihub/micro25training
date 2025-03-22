package com.productinfo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.productinfo.model.Product;

//@Service
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
	public Product getById(int productId) {
//		http://localhost:8082/catalog-service/v1/products/productId/1
		String url = BASEURL.concat("/productId/") + productId;
		ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
		Product product = response.getBody();
		return product;
	}

	@Override
	public List<Product> getAll() {
//		http://localhost:8082/catalog-service/v1/products
		ResponseEntity<List<Product>> response = (ResponseEntity) restTemplate.getForEntity(BASEURL, List.class);
		List<Product> products = response.getBody();
		System.out.println(response.getStatusCode().value());
		return products;
	}

	@Override
	public List<Product> getByCategory(String category) {
//		http://localhost:8082/catalog-service/v1/products/category/Sports
		String url = BASEURL.concat("/category/").concat(category);
		ResponseEntity<List<Product>> response = (ResponseEntity) restTemplate.getForEntity(url, List.class);
		List<Product> products = response.getBody();
		System.out.println(response.getStatusCode().value());
		return products;
	}

}
