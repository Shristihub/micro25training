package com.productinfo.service;

import java.util.List;

import com.productinfo.model.Product;


public interface IProductInfoService {

	Product  getById(int productId);
	List<Product> getAll();
	List<Product> getByCategory(String category);
}
