package com.productinfo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productinfo.model.Product;
import com.productinfo.model.ProdType;
import com.productinfo.service.IProductInfoService;

@RestController
@RequestMapping("/info-service/v1")
public class ProductInfoController {
	
	@Autowired
	private IProductInfoService productInfoService;
//	
	//use feign client reference
//	@Autowired
//	private ProductCatalogClient productInfoService;
	
	
	
	@GetMapping("/productInfo/productId/{productId}")
	ResponseEntity<ProdType>  fetchByIdFromCatalog(@PathVariable int productId){
		ProdType productType = productInfoService.getById(productId);
		return ResponseEntity.ok(productType);
		
	}
	@GetMapping("/productInfo")
	ResponseEntity<List<Product>> fetchAllFromCatalog(){
		List<Product> products = productInfoService.getAll();
		return ResponseEntity.ok(products);
	}
	@GetMapping("/productInfo/category/{category}")
	ResponseEntity<List<Product>> fetchByCatFromCategory(@PathVariable String category){
		List<Product> products = productInfoService.getByCategory(category);
		return ResponseEntity.ok(products);
		
	}

}









