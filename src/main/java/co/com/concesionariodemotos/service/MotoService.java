package co.com.concesionariodemotos.service;

import java.util.List;

import co.com.concesionariodemotos.model.Moto;

public interface MotoService {
    
    List<Moto> getAll();
    Moto getById(Long productId);
    List<Moto> getByCodigo(String codigo);
    Moto addProduct(Moto product);
    Moto updateProduct(Long productId, Moto newProduct);
    void deleteProduct(Long productId);
    Moto addMoto(Moto moto);
    Moto updateMoto(Long id, Moto moto);
    void deleteMoto(Long id);
    Moto getMotoByMotoId(Long motoId);

}