package com.productinfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Offers {
	private Integer offerId;
	private String offerType; // cashback, partner offer,bank offer,no cost emi
	private String offerDesc;
	
	
}






