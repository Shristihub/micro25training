package com.productapp.service;

import java.util.List;

import com.productapp.model.Brand;

public interface IBrandService {

	// inbuilt methods
	void addBrand(Brand brand);
	void updateBrand(Brand brand);
	void deleteBrand(int brandId);
	Brand getById(int brandId);
	List<Brand> getAll();
	
}













