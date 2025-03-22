package com.inventoryapp.service;

import com.inventoryapp.model.InventoryDTO;

public interface IInventoryService {
	
	      String  addStock(InventoryDTO inventoryDTO);
	      int checkStock(int productId);
	      String updateStock(int productId, int stock);

}
