package com.productapp.service;

import java.util.List;

import com.productapp.model.Category;

public interface ICategoryService {

	// inbuilt methods
	void addCategory(Category category);
	void updateCategory(Category category);
	void deleteCategory(int categoryId);
	Category getById(int categoryId);
	List<Category> getAll();
	
}













