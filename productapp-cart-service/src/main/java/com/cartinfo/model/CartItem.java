package com.cartinfo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Entity
public class CartItem {
	@Id
	@GeneratedValue(generator = "cartitem_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cartitem_gen",sequenceName = "cartitem_seq", initialValue = 20,allocationSize = 1)
	private Integer cartitemId;
	private int userId;
	
	private int productId;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="cart_id")
	@ToString.Exclude
	@JsonIgnore
	private Cart cart;
	
	@Transient
	private String productName;
	@Transient
	private double price;
	@Transient
	private double totalPrice; //price*quantity
	
	public CartItem(int userId, int productId, int quantity) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}
	

}














