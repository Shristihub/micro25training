package com.cartinfo.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cart {
	@Id
	@GeneratedValue(generator = "cart_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cart_gen",sequenceName = "cart_seq", initialValue = 1,allocationSize = 1)
	private Integer cartId;
	private int userId;
	@OneToMany(mappedBy = "cart",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<CartItem> cartItems;
	private double totalPrice;
	
	
	public Cart(int userId, double totalPrice) {
		super();
		this.userId = userId;
		this.totalPrice = totalPrice;
	} 
	
	public void calculateTotalPrice() {
        this.totalPrice = cartItems.stream().mapToDouble(CartItem::getPrice).sum();
    }
	

}














