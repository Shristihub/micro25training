package com.productapp.util;

import org.springframework.stereotype.Component;

import com.productapp.model.Category;
import com.productapp.model.dtos.CategoryDTO;

@Component
public class CategoryMapper {

	Category convertToCatEntity(CategoryDTO categoryDTO){
		Category category = new Category();
		category.setCategoryId(categoryDTO.getCategoryId());
		category.setCategoryName(categoryDTO.getCategoryName());
		category.setSubcategory(categoryDTO.getSubcategory());
		return category;
		
	}
	CategoryDTO convertToCatDTO(Category category){
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryId(category.getCategoryId());
		categoryDTO.setCategoryName(category.getCategoryName());
		categoryDTO.setSubcategory(category.getSubcategory());
		return categoryDTO;
		
	}
}
