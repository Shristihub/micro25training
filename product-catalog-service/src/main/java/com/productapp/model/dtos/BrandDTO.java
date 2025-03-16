package com.productapp.model.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BrandDTO {

	private Integer brandId;
	private String brandName;
	private String type; 
	@ToString.Exclude
	@JsonIgnore // to avoid an infinite loop
	List<ProductDTO> products;
	public BrandDTO(String brandName, String type) {
		super();
		this.brandName = brandName;
		this.type = type;
	}
	
	

}
