package com.productapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Offers {
	@Id
	@GeneratedValue(generator = "offers_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "offers_gen",sequenceName = "offers_seq", initialValue = 100,allocationSize = 1)
	private Integer offerId;
	@Column(length = 30)
	private String offerType; // cashback, partner offer,bank offer,no cost emi
	@Column(length = 30)
	private String offerDesc;
	
	public Offers(String offerType, String offerDesc) {
		super();
		this.offerType = offerType;
		this.offerDesc = offerDesc;
	}
	
	
}






