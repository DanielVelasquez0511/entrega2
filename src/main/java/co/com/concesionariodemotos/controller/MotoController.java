package co.com.concesionariodemotos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.concesionariodemotos.model.Moto;
import co.com.concesionariodemotos.service.MotoService;

@RestController
@RequestMapping("/motos")
public class MotoController extends BaseController{
    
    @Autowired
    private MotoService motoService;

    @GetMapping
    public List<Moto> buscarMotosPorCodigo(@RequestParam(required = false) String codigo){
        if (codigo!= null &&!codigo.isEmpty()) {
            return motoService.getByCodigo(codigo);
        }else{
            return motoService.getAll();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> obtenerMotoPorId(@PathVariable Long id){
        Moto moto = motoService.getById(id);
        if (moto!= null) {
            return ResponseEntity.ok(moto);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Moto> crearMoto(@RequestBody Moto moto){
        Moto nuevoMoto = motoService.addMoto(moto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMoto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Moto> actualizarMoto(@PathVariable Long id, @RequestBody Moto moto){
        Moto motoActualizado = motoService.updateMoto(id, moto);
        if (motoActualizado!= null) {
            return ResponseEntity.ok(motoActualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMoto(@PathVariable Long id){
        motoService.deleteMoto(id);
        return ResponseEntity.noContent().build();
    }

}