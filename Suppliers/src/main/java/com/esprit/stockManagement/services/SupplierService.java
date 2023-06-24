package com.esprit.stockManagement.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.stockManagement.entities.Supplier;
import com.esprit.stockManagement.repositories.ISupplierRepository;


@Service
public class SupplierService  implements IsupplierService {
	@Autowired
	ISupplierRepository iSupplierRepository;
	
	@Override
	public List<Supplier> getallSuppliers() {
		return (List<Supplier>) iSupplierRepository.findAll();
	}

	@Override
	public Supplier getSupplierById(Long supplierId) {
		
		return iSupplierRepository.findById(supplierId).get();
	};
	

	@Override
	public Supplier addSupplier(Supplier supplier) {
		
		return iSupplierRepository.save(supplier);
	}


	
}
