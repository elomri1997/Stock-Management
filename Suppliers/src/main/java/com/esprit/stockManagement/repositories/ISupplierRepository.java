package com.esprit.stockManagement.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.stockManagement.entities.Supplier;

@Repository
public interface ISupplierRepository extends  CrudRepository<Supplier, Long>{

}
