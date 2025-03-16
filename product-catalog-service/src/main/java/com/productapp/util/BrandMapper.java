package com.productapp.util;

import org.springframework.stereotype.Component;

import com.productapp.model.Brand;
import com.productapp.model.dtos.BrandDTO;

@Component
public class BrandMapper {

	Brand convertToBrandEntity(BrandDTO brandDTO){
		Brand brand = new Brand();
		brand.setBrandId(brandDTO.getBrandId());
		brand.setBrandName(brandDTO.getBrandName());
		brand.setType(brandDTO.getType());
		return brand;
	}
	
	BrandDTO convertToBrandDTO(Brand brand){
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setBrandId(brand.getBrandId());
		brandDTO.setBrandName(brand.getBrandName());
		brandDTO.setType(brand.getType());
		return brandDTO;
	}
}
