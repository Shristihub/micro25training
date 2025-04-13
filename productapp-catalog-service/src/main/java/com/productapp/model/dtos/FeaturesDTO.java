package com.productapp.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FeaturesDTO {
	
	private Integer featuresId;
	private String color;
	private String material;
	private String description;
	public FeaturesDTO(String color, String material, String description) {
		super();
		this.color = color;
		this.material = material;
		this.description = description;
	}

	
}
