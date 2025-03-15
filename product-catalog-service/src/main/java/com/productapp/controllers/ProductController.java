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

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@RestController
@RequestMapping("/productcatalog-service/v1")
public class ProductController {

	@Autowired
	private IProductService productService;

	@PostMapping("/products")
	ResponseEntity<Void> addProduct(@RequestBody Product product) {
	 productService.addProduct(product);
	 return ResponseEntity.ok().build();
	}
	@PutMapping("/products")
	ResponseEntity<Void> updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Updating one product");
		return ResponseEntity.ok().headers(headers).build();
	}
	@DeleteMapping("/products/productId/{productId}")
	ResponseEntity<Void> deleteProduct(@RequestBody int productId) {
		productService.deleteProduct(productId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Deleting one product by Id "+productId);
		return ResponseEntity.ok().headers(headers).build();
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAll() {
		List<Product> products = productService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning list of products");
		headers.add("desc", "List of all products");
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(products);
	}

	@GetMapping("/products/productId/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable int productId) {
		Product product = productService.getById(productId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning one product by id");
		return new ResponseEntity<>(product, headers, HttpStatusCode.valueOf(HttpStatus.OK.value()));
	}

	@GetMapping("/products/category/{category}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category) {
		List<Product> products = productService.getByCategory(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning list of products by category" + category);
		headers.add("desc", "Category " + category);
		return ResponseEntity.ok().headers(headers).body(products);
	}

	@GetMapping("/products/features/color/{color}")
	public ResponseEntity<List<Product>> getProductByColor(@PathVariable String color) {
		List<Product> products = productService.getByColor(color);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning list of products by color" + color);
		headers.add("desc", "Color " + color);
		return ResponseEntity.ok().headers(headers).body(products);

	}

}
