package co.com.concesionariodemotos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "motorcycles")
@Data
public class Moto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private Integer precio; // pesos colombianos.

    private String nombre;

    private String categoria; 

    private Double cilindrada; // cc

    private String marca; //ejem honda, susuki todas esas

    private String descripcion;

    private String imagen;

    private Integer numeroPasajeros; 

    private Double velocidadMaxima; //velocidad maxima

}