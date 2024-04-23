package co.com.concesionariodemotos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.concesionariodemotos.model.Moto;
import co.com.concesionariodemotos.repository.MotoRepository;

@Service
public class MotoServiceImpl implements MotoService{
    
    @Autowired
    private MotoRepository productRepository;

    @Override
    public List<Moto> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Moto getById(Long id) {
        return productRepository.findById(id)
       .orElseThrow(() -> new IllegalArgumentException("The product with ID " + id + " doesn't exist."));
    }

    @Override
    public List<Moto> getByCodigo(String codigo){
        return productRepository.findByCodigo(codigo);
    }

    @Override
    public Moto addProduct(Moto product){
        return productRepository.save(product);
    }

    @SuppressWarnings("null")
    @Override
    public Moto updateProduct(Long id, Moto newProduct){
        if (productRepository.existsById(null)) {
            newProduct.setId(id);
            return productRepository.save(newProduct);
        }else{
            throw new IllegalArgumentException("The product with ID " + id + " doesn't exist.");
        }
    }

    @Override
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    @Override
    public Moto addMoto(Moto moto) {
  
        throw new UnsupportedOperationException("Unimplemented method 'addMoto'");
    }

    @Override
    public Moto updateMoto(Long id, Moto moto) {

        throw new UnsupportedOperationException("Unimplemented method 'updateMoto'");
    }

    @Override
    public void deleteMoto(Long id) {

        throw new UnsupportedOperationException("Unimplemented method 'deleteMoto'");
    }

    @Override
    public Moto getMotoByMotoId(Long motoId) {

        throw new UnsupportedOperationException("Unimplemented method 'getMotoByMotoId'");
    }

}