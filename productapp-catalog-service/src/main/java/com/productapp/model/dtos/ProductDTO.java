
package com.productapp.model.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
	private String productName;
	private Integer productId;
	private double price;
	private FeaturesDTO features;
	private List<OffersDTO> offers;
	private BrandDTO brand;
	private List<CategoryDTO> categories;
	private List<String> deliveryType; // free, prime,standard
	private List<String> paymentModes; // UPI,COD,credit card, debit card
	private int stock;
	

	

	

}
