package com.inventoryapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryapp.model.Inventory;
import com.inventoryapp.model.InventoryDTO;
import com.inventoryapp.service.IInventoryService;

@RestController
@RequestMapping("/inventory-service/v1")
public class InventoryController {
	@Autowired
	private IInventoryService inventoryService;
   
//	http://localhost:8081/inventory-service/v1/inventory
	@PostMapping("/inventory")
	ResponseEntity<String> addStock(@RequestBody InventoryDTO inventoryDTO) {
		String result =  inventoryService.addStock(inventoryDTO);
		return ResponseEntity.ok(result);
		 
	}
//	http://localhost:8081/inventory-service/v1/inventory/productId/1
	@GetMapping("/inventory/productId/{productId}")
	ResponseEntity<Integer> checkStock(@PathVariable int productId) {
		int stock = inventoryService.checkStock(productId);
		return ResponseEntity.ok(stock);
	}
//	http://localhost:8081/inventory-service/v1/inventory?productId=1&stock=200
	@PutMapping("/inventory")
	ResponseEntity<String> updateStock(@RequestParam int productId, @RequestParam int stock) {
		String result =  inventoryService.updateStock(productId,stock);
		return ResponseEntity.ok(result);
	}
}
