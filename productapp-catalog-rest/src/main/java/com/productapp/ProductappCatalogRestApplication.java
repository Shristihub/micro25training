package com.productapp;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
import com.productapp.service.IProductService;

@SpringBootApplication
public class ProductappCatalogRestApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProductappCatalogRestApplication.class, args);
	}

	@Autowired
	private IProductService productService;
	@Override
	public void run(String... args) throws Exception {
		Product product = new Product("Mobile","Samsung","Gadgets",12000.60);
		productService.addProduct(product);
		
		product = new Product("Television","Samsung","Electronics",120000.60);
		productService.addProduct(product);
		product = new Product("Pen","Parker","Stationary",120);
		productService.addProduct(product);
		product = new Product("Notebook","Classmate","Stationary",180);
		productService.addProduct(product);
		System.out.println();
//		productService.getAll().forEach(product->System.out.println(product));
		productService.getAll().forEach(System.out::println);
		
		System.out.println("get one product");
		Product nproduct = productService.getById(50);
		//update product
		nproduct.setCategory("Electronics");
		nproduct.setPrice(30000);
		productService.updateProduct(nproduct);
		
//		System.out.println();
//		productService.getAll().forEach(System.out::println);
//		System.out.println();
//		System.out.println("....By brand......");
//		productService.getByBrand("Samsung").forEach(System.out::println);
//		System.out.println();
//		System.out.println("by category");
//		productService.getByCategory("Stationary").forEach(System.out::println);
//		System.out.println();
//		System.out.println("by price");
//		productService.getByPriceLessThan(600).forEach(System.out::println);
//		System.out.println();
//		System.out.println("by category and price");
//		productService.getAByCatAndPrice("Electronics",50000).forEach(System.out::println);
		
		System.out.println();
		productService.getByBrandPrice("Samsung", 200000).forEach(System.out::println);
		System.out.println();
		productService.getByProductNameHas("e").forEach(System.out::println);
		System.out.println();
		productService.getByCat("Electronics").forEach(System.out::println);
		System.out.println();
		productService.getAByCatPrice("Stationary", 2000).forEach(System.out::println);
		
		System.out.println();
		productService.getByBrandProductName("Samsung", "Mobile").forEach(System.out::println);
	
	}

}







