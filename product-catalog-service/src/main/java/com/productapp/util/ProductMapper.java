package com.productapp.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.productapp.model.Category;
import com.productapp.model.Product;
import com.productapp.model.dtos.BrandDTO;
import com.productapp.model.dtos.CategoryDTO;
import com.productapp.model.dtos.FeaturesDTO;
import com.productapp.model.dtos.ProductDTO;

@Component
public class ProductMapper {
	
	@Autowired
	FeaturesMapper featuresMapper;
	
	@Autowired
	BrandMapper brandMapper;
	@Autowired
	CategoryMapper categoryMapper;
	
	public Product convertToEntity(ProductDTO productDTO){
		Product product = new Product();
		product.setProductName(productDTO.getProductName());
		product.setProductId(productDTO.getProductId());
		product.setPrice(productDTO.getPrice());
		BrandDTO brandDTO = productDTO.getBrand();
		product.setBrand(brandMapper.convertToBrandEntity(brandDTO));
		
		List<CategoryDTO> categoriesDTO =  productDTO.getCategories();
		List<Category> categories = 
			categoriesDTO.stream()
			// input is dto object and output is category 
		     .map(categoryDTO->categoryMapper.convertToCatEntity(categoryDTO))
		     .toList();
		product.setCategories(categories);
		product.setDeliveryType(productDTO.getDeliveryType());
		
		FeaturesDTO featuresDTO =  productDTO.getFeatures();
		product.setFeatures(featuresMapper.convertToFeaturesEntity(featuresDTO));
		
		product.setPaymentModes(productDTO.getPaymentModes());
		return product;
		
		
	}
   public ProductDTO convertToDTO(Product product){
	   ProductDTO productDTO = new ProductDTO();
	   
		return productDTO;
	}

}
