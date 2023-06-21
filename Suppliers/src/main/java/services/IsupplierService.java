package services;

import java.util.List;
import entities.Supplier;

public interface IsupplierService {

	List<Supplier> getallSuppliers();
	Supplier getSupplierById(Long SupplierId);
	Supplier addSupplier(Supplier supplier);
}
