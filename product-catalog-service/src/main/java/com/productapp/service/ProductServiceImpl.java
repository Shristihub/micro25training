package com.productapp.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.productapp.model.Product;
import com.productapp.model.dtos.ProductDTO;
import com.productapp.repository.IProductRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	private IProductRepository productRepository;
	private ModelMapper mapper;
	
	
	public ProductServiceImpl(IProductRepository productRepository, ModelMapper mapper) {
		super();
		this.productRepository = productRepository;
		this.mapper = mapper;
	}

	@Override
	public void addProduct(ProductDTO productDTO) {
		Product product = mapper.map(productDTO,Product.class);
		productRepository.save(product);
	}

	@Override
	public void updateProduct(ProductDTO productDTO) {
		Product product = mapper.map(productDTO,Product.class);
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
			ProductDTO productDTO = mapper.map(product,ProductDTO.class);
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
		   .map(product->mapper.map(product,ProductDTO.class))
		   .toList();
	}

	@Override
	public List<ProductDTO> getByColor(String color) {
		List<Product> products = productRepository.findByColor(color,Sort.by(Direction.DESC,"price"));
		return products.stream()
		   .map(product->mapper.map(product,ProductDTO.class))
		   .toList();
	}

	@Override
	public List<ProductDTO> getByOfferType(String type) {
		List<Product> products = productRepository.getByOfferType(type);
		return products.stream()
		   .map(product->mapper.map(product,ProductDTO.class))
		   .toList();
	}

	@Override
	public List<ProductDTO> getByBrandProductName(String brand, String productName) {
		List<Product> products = productRepository.getByBrandProductName(brand, productName);
		return products.stream()
		   .map(product->mapper.map(product,ProductDTO.class))
		   .toList();
	}

	@Override
	public List<ProductDTO> findByBrandColor(String brand, String color) {
		List<Product> products = productRepository.findByBrandColor(brand, color);
		return products.stream()
		   .map(product->mapper.map(product,ProductDTO.class))
		   .toList();
	}

	@Override
	public List<ProductDTO> getByCategory(String category) {
		List<Product> products = productRepository.getByCategory(category);
		return products.stream()
		   .map(product->mapper.map(product,ProductDTO.class))
		   .toList();
	}
}
