package com.productapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.Brand;
import com.productapp.model.Category;
import com.productapp.repository.IBrandRepository;

@Service
public class BrandServiceImpl implements IBrandService{
	
	@Autowired
	private IBrandRepository brandRepository;

	@Override
	public void addBrand(Brand brand) {
		brandRepository.save(brand);
	}

	@Override
	public void updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBrand(int brandId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Brand getById(int brandId) {
		Optional<Brand> brandopt = brandRepository.findById(brandId);
		if (brandopt.isPresent())
			return brandopt.get();
		else
			return null;
	}

	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
