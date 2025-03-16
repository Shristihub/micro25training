package com.productapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.productapp.model.Product;
import com.productapp.model.dtos.ProductDTO;
import com.productapp.repository.IProductRepository;
import com.productapp.util.ProductMapper;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	private IProductRepository productRepository;
	private ProductMapper mapper;
	
	
	public ProductServiceImpl(IProductRepository productRepository, ProductMapper mapper) {
		super();
		this.productRepository = productRepository;
		this.mapper = mapper;
	}

	@Override
	public void addProduct(ProductDTO productDTO) {
		Product product = mapper.convertToEntity(productDTO);
		productRepository.save(product);
	}

	@Override
	public void updateProduct(ProductDTO productDTO) {
		Product product = mapper.convertToEntity(productDTO);
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public ProductDTO getById(int productId) {
		Optional<Product> productopt = productRepository.findById(productId);
		if (productopt.isPresent()) {
			Product  product = productopt.get();
			ProductDTO productDTO = mapper.convertToDTO(product);
			return productDTO;
		}
		else
			return null;

	}

	@Override
	public List<ProductDTO> getAll() {
		// sorting 
		Sort sort= Sort.by("productName");
		List<Product> products = productRepository.findAll(sort);
		return products.stream()
		   .map(product->mapper.convertToDTO(product))
		   .toList();
	}

	@Override
	public List<ProductDTO> getByColor(String color) {
		return productRepository.findByColor(color,Sort.by(Direction.DESC,"price"));
	}

	@Override
	public List<ProductDTO> getByOfferType(String type) {
		return productRepository.getByOfferType(type);
	}

	@Override
	public List<ProductDTO> getByBrandProductName(String brand, String productName) {
		return productRepository.getByBrandProductName(brand, productName);
	}

	@Override
	public List<ProductDTO> findByBrandColor(String brand, String color) {
		return productRepository.findByBrandColor(brand, color);
	}

	@Override
	public List<ProductDTO> getByCategory(String category) {
		return productRepository.getByCategory(category);
	}
}
