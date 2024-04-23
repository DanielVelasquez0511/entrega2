package co.com.concesionariodemotos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.concesionariodemotos.model.Moto;

import java.util.List;

public interface MotoRepository extends JpaRepository<Moto, Long>{
    List<Moto> findByCodigo(String codigo);
}