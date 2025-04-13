package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.dtos.ProductDTO;
import com.productapp.service.IProductService;

@RestController
@RequestMapping("/catalog-service/v1")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	//	http://localhost:8082/catalog-service/v1/products
	@PostMapping("/products")
	ResponseEntity<Void> addProduct(@RequestBody ProductDTO productDTO) {
	 productService.addProduct(productDTO);
	 return ResponseEntity.status(201).build();
	}
	@PutMapping("/products")
	ResponseEntity<Void> updateProduct(@RequestBody ProductDTO productDTO) {
		productService.updateProduct(productDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Updating one product");
		return ResponseEntity.accepted().headers(headers).build();
	}
	@DeleteMapping("/products/productId/{productId}")
	ResponseEntity<Void> deleteProduct(@RequestBody int productId) {
		productService.deleteProduct(productId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Deleting one product by Id "+productId);
		return ResponseEntity.ok().headers(headers).build();
	}
//	http://localhost:8082/catalog-service/v1/products
	@GetMapping("/products")
	public ResponseEntity<List<ProductDTO>> getAll() {
		List<ProductDTO> products = productService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning list of products");
		headers.add("desc", "List of all products");
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(products);
	}
//	http://localhost:8082/catalog-service/v1/products/productId/1
	@GetMapping("/products/productId/{productId}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable int productId) {
		ProductDTO productDTO = productService.getById(productId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning one product by id");
		return new ResponseEntity<ProductDTO>(productDTO, headers, HttpStatusCode.valueOf(HttpStatus.OK.value()));
	}
//	http://localhost:8082/catalog-service/v1/products/category/Electronics
	@GetMapping("/products/category/{category}")
	public ResponseEntity<List<ProductDTO>> getProductByCategory(@PathVariable String category) {
		List<ProductDTO> products = productService.getByCategory(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning list of products by category" + category);
		headers.add("desc", "Category " + category);
		return ResponseEntity.ok().headers(headers).body(products);
	}

	@GetMapping("/products/features/color/{color}")
	public ResponseEntity<List<ProductDTO>> getProductByColor(@PathVariable String color) {
		List<ProductDTO> products = productService.getByColor(color);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning list of products by color" + color);
		headers.add("desc", "Color " + color);
		return ResponseEntity.ok().headers(headers).body(products);

	}

}
