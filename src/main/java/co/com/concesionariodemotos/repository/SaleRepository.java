package co.com.concesionariodemotos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.concesionariodemotos.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
    
}