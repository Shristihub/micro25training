package com.productapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Category {

	@Id
	@GeneratedValue(generator = "category_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "category_gen",sequenceName = "category_seq", initialValue = 1,allocationSize = 1)
	private Integer categoryId;
	@Column(length = 30)
	private String categoryName;
	@Column(length = 30)
	private String subcategory;
	
	@ManyToMany(mappedBy="categories")
	@ToString.Exclude
	@JsonIgnore
	private List<Product> products;

	public Category(String categoryName, String subcategory) {
		super();
		this.categoryName = categoryName;
		this.subcategory = subcategory;
	}
	
	
	
	
	
}
