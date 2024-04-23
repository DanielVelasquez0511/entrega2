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
import org.springframework.web.bind.annotation.RestController;

import co.com.concesionariodemotos.model.Moto;
import co.com.concesionariodemotos.service.MotoService;

@RestController
@RequestMapping("/motos")
public class ClientController extends BaseController{
    
    @Autowired
    private MotoService motoService;

    @GetMapping
    public List<Moto> getAllMotos() {
        return motoService.getAll();
    }

    @GetMapping("/{motoId}")
    public ResponseEntity<Moto> getMotoById(@PathVariable Long motoId) {
        Moto moto = motoService.getMotoByMotoId(motoId);
        if (moto!= null) {
            return ResponseEntity.ok(moto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Moto> createMoto(@RequestBody Moto moto) {
        Moto newMoto = motoService.addMoto(moto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMoto);
    }

    @PutMapping("/{motoId}")
    public ResponseEntity<Moto> updateMotoById(@PathVariable Long motoId, @RequestBody Moto moto){
        Moto updaMoto = motoService.updateMoto(motoId, moto);
        if (updaMoto!= null) {
            return ResponseEntity.ok(updaMoto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{motoId}")
    public ResponseEntity<Void> deleteMotoById(@PathVariable Long motoId){
        motoService.deleteMoto(motoId);
        return ResponseEntity.noContent().build();
    }

}