package com.productinfo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
// to handle errors implement a common interface EXceptionType
public class Product implements ProdType{
	private String productName;
	private Integer productId;
	private double price;
	private Features features;
	private List<Offers> offers;
	private Brand brand;
	private List<Category> categories;
	private List<String> deliveryType; // free, prime,standard
	private List<String> paymentModes; // UPI,COD,credit card, debit card
	
	

	

	

}
