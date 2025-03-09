package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;
	@GetMapping("/products")
	public List<Product> getAll(){
		return productService.getAll();
	}
}
