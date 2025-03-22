package com.productinfo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {

	private Integer categoryId;
	private String categoryName;
	private String subcategory;
	
	@ToString.Exclude
	@JsonIgnore // to avoid an infinite loop
	private List<Product> products;

	public Category(String categoryName, String subcategory) {
		super();
		this.categoryName = categoryName;
		this.subcategory = subcategory;
	}
	
	
	
	
	
}
