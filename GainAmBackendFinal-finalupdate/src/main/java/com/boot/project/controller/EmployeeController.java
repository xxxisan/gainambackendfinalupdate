package com.boot.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.boot.project.model.Inventory;
import com.boot.project.model.Product;
import com.boot.project.model.StringResponse;
import com.boot.project.service.InventoryService;
import com.boot.project.service.ProductService;

@RestController
public class EmployeeController {

    
    
    @Autowired
	private InventoryService inventoryService;

    @Autowired
    private ProductService productService;

    
    //inventory
   

	@GetMapping("/api/employee/inventory-all")
	public ResponseEntity<?> findAllInventories() {
		return new ResponseEntity<>(inventoryService.findAllInventories(), HttpStatus.OK);
	}

	@GetMapping("/api/employee/inventory-number")
	public ResponseEntity<?> numberOfInventorys() {
		Long number = inventoryService.numberOfInventories();
		StringResponse response = new StringResponse();
		response.setResponse(number.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
    
    //product
 

    @GetMapping("/api/employee/product-all")
    public ResponseEntity<?> findAllProducts(){
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/api/employee/product-number")
    public ResponseEntity<?> numberOfProducts(){
        Long number = productService.numberOfProducts();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}