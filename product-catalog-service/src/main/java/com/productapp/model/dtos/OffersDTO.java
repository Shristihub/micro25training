package com.productapp.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OffersDTO {
	private Integer offerId;
	private String offerType; // cashback, partner offer,bank offer,no cost emi
	private String offerDesc;
	
	public OffersDTO(String offerType, String offerDesc) {
		super();
		this.offerType = offerType;
		this.offerDesc = offerDesc;
	}
	
	
}






