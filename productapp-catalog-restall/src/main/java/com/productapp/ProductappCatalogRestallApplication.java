package com.productapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.Brand;
import com.productapp.model.Category;
import com.productapp.model.Features;
import com.productapp.model.OfferType;
import com.productapp.model.Offers;
import com.productapp.model.Product;
import com.productapp.service.IBrandService;
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
	@Autowired
	private IBrandService brandService;
	@Override
	public void run(String... args) throws Exception {
		
//		Category category = new Category("Electronics","Gadgets");
//		categoryService.addCategory(category);
//		category = new Category("Sports","Accessories");
//		categoryService.addCategory(category);
//		category = new Category("Kids","Toys");
//		categoryService.addCategory(category);
//		category = new Category("Mobiles","Mobiles&Acc");
//		categoryService.addCategory(category);
		

//		Features features = new Features("white","Steel","Good camera");
//		Offers offer1 = new Offers(OfferType.EMI.getType(),"no cost emi above 10000");
//		Offers offer2 = new Offers(OfferType.CB.getType(),"cash back upto 2000");
//		Offers offer3 = new Offers(OfferType.BANK.getType(),"upto 1000 discount on items");
//		//add to a List
//		List<Offers> offersList = Arrays.asList(offer1,offer2,offer3);
//
//		// get the category by Id
//		Category category1 = categoryService.getById(1);
//		Category category2 = categoryService.getById(4);
//		
//		List<Category> categories = Arrays.asList(category1,category2);
//		
//		//create a brand;
//		Brand brand = new Brand("Samsung","Electronics");
//		brandService.addBrand(brand);
//		brand = new Brand("Nike","Sports");
//		brandService.addBrand(brand);
////		
//		Brand nbrand = brandService.getById(20);
//		
//		Product product = 
//			new Product("Television",200000,features,offersList,Arrays.asList(category1),Arrays.asList("PRIME"),Arrays.asList("COD","UPI"),nbrand);
//		productService.addProduct(product);
//		
//		// get the category by Id
//		category1 = categoryService.getById(2);
//		category2 = categoryService.getById(3);
//		
//		Features features1 = new Features("black","rubber","bouncy");
//		offer1 = new Offers(OfferType.EMI.getType(),"no cost emi above 40000");
//		offer2 = new Offers(OfferType.CB.getType(),"cash back upto 200");
//		
//		nbrand = brandService.getById(21);
//		Product product1 = 
//			new Product("Shoe",2000,features1,Arrays.asList(offer1), Arrays.asList(category1),Arrays.asList("STANDARD","PRIME"),Arrays.asList("CREDIT"),nbrand);
//		productService.addProduct(product1);
//		
//		productService.getAll().forEach(System.out::println);
//		
//		productService.getByColor("white").forEach(System.out::println);
//		System.out.println();
//		productService.getByOfferType("CASH BACK").forEach(System.out::println);
//		System.out.println();
//		productService.getByBrandProductName("Samsung", "Television").forEach(System.out::println);
//		
	}

}






