package com.productapp.util;

import org.springframework.stereotype.Component;

import com.productapp.model.Features;
import com.productapp.model.dtos.FeaturesDTO;

@Component
public class FeaturesMapper {

	Features convertToFeaturesEntity(FeaturesDTO featuresDTO){
		Features features = new Features();
		features.setColor(featuresDTO.getColor());
		features.setDescription(featuresDTO.getDescription());
		features.setFeaturesId(featuresDTO.getFeaturesId());
		features.setMaterial(featuresDTO.getMaterial());
		return features;
	}
	FeaturesDTO convertToFeaturesDTO(Features features){
		FeaturesDTO featuresDTO = new FeaturesDTO();
		featuresDTO.setColor(features.getColor());
		featuresDTO.setDescription(features.getDescription());
		featuresDTO.setFeaturesId(features.getFeaturesId());
		featuresDTO.setMaterial(features.getMaterial());
		return featuresDTO;
	}
	
}





