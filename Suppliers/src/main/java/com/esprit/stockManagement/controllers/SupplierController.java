package com.esprit.stockManagement.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.stockManagement.entities.Supplier;
import com.esprit.stockManagement.services.IsupplierService;


@RestController
@RequestMapping(value = "API")
public class SupplierController {
	
	@Autowired
	IsupplierService supplierService;
	
	@GetMapping("/getAllSuppliers")
	public List<Supplier> getallSuppliers(){
	return supplierService.getallSuppliers();
	}
	@GetMapping("/Supplier/{id}")
	public Supplier getSupplierById(@PathVariable(value = "id") Long supplierId){
	return supplierService.getSupplierById(supplierId);
	}
	
	@PostMapping("/AddSupplier")
	public Supplier addSupplier(@RequestBody Supplier supplier){
		
		return supplierService.addSupplier(supplier);
	}
	
}
