package com.inventoryapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Inventory {
	@Id
	@GeneratedValue(generator = "inventory_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "inventory_gen",sequenceName = "inventory_seq", initialValue = 20,allocationSize = 1)
	private Integer inventoryId;
	
	@Column(unique = true)
	private Integer productId;
	@Column(name = "quantity")
	private int stock;
	public Inventory(Integer productId, int stock) {
		super();
		this.productId = productId;
		this.stock = stock;
	}
	
	

}
