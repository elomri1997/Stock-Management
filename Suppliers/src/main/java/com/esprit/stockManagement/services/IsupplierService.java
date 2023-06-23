package com.esprit.stockManagement.services;

import java.util.List;

import com.esprit.stockManagement.entities.Supplier;

public interface IsupplierService {

	List<Supplier> getallSuppliers();
	Supplier getSupplierById(Long SupplierId);
	Supplier addSupplier(Supplier supplier);
}
