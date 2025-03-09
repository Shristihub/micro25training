package com.productapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.Category;
import com.productapp.model.Features;
import com.productapp.model.OfferType;
import com.productapp.model.Offers;
import com.productapp.model.Product;
import com.productapp.service.ICategoryService;
import com.productapp.service.IProductService;

@SpringBootApplication
public class ProductappCatalogRestallApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProductappCatalogRestallApplication.class, args);
	}

	@Autowired
	private IProductService productService;
	@Autowired
	private ICategoryService categoryService;
	@Override
	public void run(String... args) throws Exception {
		
		Category category = new Category("Electronics","Gadgets");
		categoryService.addCategory(category);
		category = new Category("Sports","Accessories");
		categoryService.addCategory(category);
		category = new Category("Kids","Toys");
		categoryService.addCategory(category);
		category = new Category("Mobiles","Mobiles&Acc");
		categoryService.addCategory(category);
		

		Features features = new Features("white","Steel","Good camera");
		Offers offer1 = new Offers(OfferType.EMI.getType(),"no cost emi above 10000");
		Offers offer2 = new Offers(OfferType.CB.getType(),"cash back upto 2000");
		Offers offer3 = new Offers(OfferType.BANK.getType(),"upto 1000 discount on items");
		//add to a List
		List<Offers> offersList = Arrays.asList(offer1,offer2,offer3);

		// get the category by Id
		Category category1 = categoryService.getById(1);
		Category category2 = categoryService.getById(4);
		
		List<Category> categories = Arrays.asList(category1,category2);
		Product product = new Product("Galaxy M16",20000,features,offersList,categories);
		productService.addProduct(product);
		
		// get the category by Id
		category1 = categoryService.getById(2);
		category2 = categoryService.getById(3);
		
		Features features1 = new Features("red","rubber","bouncy");
		Product product1 = new Product("Ball",200,features1,Arrays.asList(offer1,offer2), Arrays.asList(category1,category2));
		productService.addProduct(product1);
		
		productService.getAll().forEach(System.out::println);
		
		
		
	}

}
