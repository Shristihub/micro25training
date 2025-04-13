package com.productapp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

	// derived query
//	List<Product> findByFeaturesColor(String color);

	// 2nd parameter is used for sorting not for querying
	@Query("from Product p inner join p.features f where f.color=?1")
	List<Product> findByColor(String color,Sort sort);

	@Query("from Product p inner join p.offers o where o.offerType=?1")
	List<Product> getByOfferType(String type);

	@Query("from Product p inner join p.brand br where br.brandName=?1 and p.productName=?2")
	 List<Product> getByBrandProductName(String brand, String productName);
	
	@Query("from Product p inner join p.brand b inner join p.features f where f.color=?2and b.brandName=?1")
	List<Product> findByBrandColor(String brand,String color);
	
	@Query("from Product p inner join p.categories c where c.categoryName=?1")
	List<Product> getByCategory(String category);
	}





