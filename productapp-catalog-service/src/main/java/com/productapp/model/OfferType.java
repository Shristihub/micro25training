package com.productapp.model;

public enum OfferType {

	CB("CASH BACK"),
	BANK("BANK OFFER"),
	PARTNER("PARTNER OFFER"),
	EMI("NO COST EMI OFFER");
	
	private String type;

	private OfferType(String offerType) {
		this. type = offerType;
	}

	public String getType() {
		return type;
	}
	
}
