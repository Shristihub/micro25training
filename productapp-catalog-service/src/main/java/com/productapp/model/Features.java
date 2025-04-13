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
public class Features {
	
	@Id
	@GeneratedValue(generator = "features_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "features_gen",sequenceName = "features_seq", initialValue = 10,allocationSize = 1)
	private Integer featuresId;
	@Column(length = 30)
	private String color;
	@Column(length = 30)
	private String material;
	@Column(length = 30)
	private String description;
	public Features(String color, String material, String description) {
		super();
		this.color = color;
		this.material = material;
		this.description = description;
	}

	
}
