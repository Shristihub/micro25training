package com.productinfo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Brand {

	private Integer brandId;
	private String brandName;
	private String type; 
	@ToString.Exclude
	@JsonIgnore // to avoid an infinite loop
	List<Product> products;
	public Brand(String brandName, String type) {
		super();
		this.brandName = brandName;
		this.type = type;
	}
	
	

}
