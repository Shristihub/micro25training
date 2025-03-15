package com.productapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.productapp.model.Category;
import com.productapp.repository.ICategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	private ICategoryRepository categoryRepository;
	public CategoryServiceImpl(ICategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category getById(int categoryId) {
		Optional<Category> categoryopt = categoryRepository.findById(categoryId);
		if (categoryopt.isPresent())
			return categoryopt.get();
		else
			return null;
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
