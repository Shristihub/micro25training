package com.inventoryapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventoryapp.exception.InventoryNotFoundException;
import com.inventoryapp.model.Inventory;
import com.inventoryapp.model.InventoryDTO;
import com.inventoryapp.repository.IInventoryRepository;

@Service
public class InventoryServiceImpl implements IInventoryService{
	
	private IInventoryRepository inventoryRepository;
	

	public InventoryServiceImpl(IInventoryRepository inventoryRepository) {
		super();
		this.inventoryRepository = inventoryRepository;
	}

	@Override
	public String addStock(InventoryDTO inventoryDTO) {
		int productId = inventoryDTO.getProductId();
		Inventory inventory = inventoryRepository.findByproductId(productId)
				.orElseGet(()-> new Inventory());
		inventory.setProductId(productId);
		inventory.setStock(inventoryDTO.getStock());
		inventoryRepository.save(inventory);
		return "stock added";
	}

	@Override
	public int checkStock(int productId) {
		Inventory inventory =  inventoryRepository.findByproductId(productId)
		      .orElseThrow(()-> new InventoryNotFoundException("invalid productId"));
		return inventory.getStock();
		
	}

	@Override
	public String updateStock(int productId, int stock) {
		Inventory inventory =  inventoryRepository.findByproductId(productId)
				 .orElseThrow(()-> new InventoryNotFoundException("invalid productId"));
		inventory.setStock(stock);
		inventoryRepository.save(inventory);
		return "stock updated";
	}

	

	

}
