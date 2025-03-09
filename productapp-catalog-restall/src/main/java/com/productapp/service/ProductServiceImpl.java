package com.productapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
@Service
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
		return productRepository.findAll();
	}
}
