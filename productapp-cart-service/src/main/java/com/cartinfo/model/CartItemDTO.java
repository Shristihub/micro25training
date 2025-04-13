package com.cartinfo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItemDTO {
	private Integer cartitemId;
	private int userId;
	private int productId;
	private int quantity;
	
	
	public CartItemDTO(int userId, int productId, int quantity) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}
	

}














