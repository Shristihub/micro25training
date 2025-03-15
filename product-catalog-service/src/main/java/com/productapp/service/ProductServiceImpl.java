package com.productapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	private IProductRepository productRepository;

	public ProductServiceImpl(IProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public Product getById(int productId) {
		Optional<Product> productopt = productRepository.findById(productId);
		if (productopt.isPresent())
			return productopt.get();
		else
			return null;

	}

	@Override
	public List<Product> getAll() {
		// sorting 
		Sort sort= Sort.by("productName");
		return productRepository.findAll(sort);
	}

	@Override
	public List<Product> getByColor(String color) {
		return productRepository.findByColor(color,Sort.by(Direction.DESC,"price"));
	}

	@Override
	public List<Product> getByOfferType(String type) {
		return productRepository.getByOfferType(type);
	}

	@Override
	public List<Product> getByBrandProductName(String brand, String productName) {
		return productRepository.getByBrandProductName(brand, productName);
	}

	@Override
	public List<Product> findByBrandColor(String brand, String color) {
		return productRepository.findByBrandColor(brand, color);
	}

	@Override
	public List<Product> getByCategory(String category) {
		return productRepository.getByCategory(category);
	}
}
