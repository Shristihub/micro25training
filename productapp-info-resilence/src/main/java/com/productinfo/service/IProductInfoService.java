package com.productinfo.service;

import java.util.List;

import com.productinfo.model.Product;
import com.productinfo.model.ProdType;


public interface IProductInfoService {

	ProdType  getById(int productId);
	List<Product> getAll();
	List<Product> getByCategory(String category);
}
