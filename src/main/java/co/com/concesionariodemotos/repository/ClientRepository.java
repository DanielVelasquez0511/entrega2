package co.com.concesionariodemotos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.concesionariodemotos.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
    
}