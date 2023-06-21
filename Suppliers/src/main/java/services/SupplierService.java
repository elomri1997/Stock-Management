package services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import entities.Supplier;
import repositories.SupplierRepository;

@Service
public class SupplierService  implements IsupplierService {
	@Autowired
	SupplierRepository supplierRepository;
	
	@Override
	public List<Supplier> getallSuppliers() {
		return (List<Supplier>) supplierRepository.findAll();
	}

	@Override
	public Supplier getSupplierById(Long supplierId) {
		
		return supplierRepository.findById(supplierId).get();
	};
	

	@Override
	public Supplier addSupplier(Supplier supplier) {
		
		return supplierRepository.save(supplier);
	}


	
}
