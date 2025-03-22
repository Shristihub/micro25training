package com.inventoryapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventoryapp.model.Inventory;

@Repository
public interface IInventoryRepository extends JpaRepository<Inventory, Integer>{

	Optional<Inventory> findByproductId(int productId);
	
}
