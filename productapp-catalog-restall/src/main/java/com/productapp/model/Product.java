package com.productapp.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {
	@Column(length = 30)
	private String productName;
	@Id
	@GeneratedValue(generator = "prod_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "prod_gen", sequenceName = "prod_seq", initialValue = 50, allocationSize = 1)
	private Integer productId;
	@Column(name = "cost")
	private double price;

	@OneToOne(cascade = CascadeType.ALL)// save features before saving product
	@JoinColumn(name = "features_id") // to give different column name
	private Features features;

	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="prod_id")// to add product_id to offers table
	private List<Offers> offers;
	
	@ManyToOne
	@JoinColumn(name = "brand_id") 
	private Brand brand;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="product_category",
		joinColumns = @JoinColumn(name="product_id"),
		inverseJoinColumns = @JoinColumn(name="category_id"))
	private List<Category> categories;
	// similar to onrto many but not one to many
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "delivery",joinColumns = @JoinColumn(name="product_id"))
	@JsonIgnore
	private List<String> deliveryType; // free, prime,standard
	
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "payment",joinColumns = @JoinColumn(name="product_id"))
	@JsonIgnore
	private List<String> paymentModes; // UPI,COD,credit card, debit card

	public Product(String productName, double price, Features features, List<Offers> offers, List<Category> categories,
			List<String> deliveryType, List<String> paymentModes, Brand brand) {
		super();
		this.productName = productName;
		this.price = price;
		this.features = features;
		this.offers = offers;
		this.categories = categories;
		this.deliveryType = deliveryType;
		this.paymentModes = paymentModes;
		this.brand=brand;
	}

	

	

}
