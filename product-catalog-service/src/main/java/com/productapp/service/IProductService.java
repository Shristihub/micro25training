package com.productapp.service;

import java.util.List;

import com.productapp.model.dtos.ProductDTO;

public interface IProductService {

	// inbuilt methods
	void addProduct(ProductDTO product);
	void updateProduct(ProductDTO product);
	void deleteProduct(int productId);
	ProductDTO getById(int productId);
	List<ProductDTO> getAll();
	
	// custom query
	List<ProductDTO> getByColor(String color);
	List<ProductDTO> getByOfferType(String type);
	List<ProductDTO> getByBrandProductName(String brand, String productName);
	List<ProductDTO> findByBrandColor(String brand,String color);
	List<ProductDTO> getByCategory(String category);
}













