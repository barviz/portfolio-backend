package com.proyecto.PortfolioArgProg.controladores;

import com.proyecto.PortfolioArgProg.dtos.TecnologiaDto;
import com.proyecto.PortfolioArgProg.entidades.Tecnologia;
import com.proyecto.PortfolioArgProg.servicios.implementacion.TecnologiaServicioImplementacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Barbara
 */
@RestController
public class TecnologiaControlador {
    
    @Autowired
    private TecnologiaServicioImplementacion tecnologiaServicioImplementacion;

    @PostMapping(path = "/tecnologia")
    public ResponseEntity<Tecnologia> crearTecnologia(@RequestBody TecnologiaDto dto) {
        return new ResponseEntity<Tecnologia>(tecnologiaServicioImplementacion.crearTecnologia(dto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/tecnologia")
    public ResponseEntity<Tecnologia> actualizarTecnologia(@RequestBody TecnologiaDto dto) {
        return new ResponseEntity<Tecnologia>(tecnologiaServicioImplementacion.actualizarTecnologia(dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/tecnologia/{id}")
    public ResponseEntity<String> eliminarTecnologia(@PathVariable Long id) {
        tecnologiaServicioImplementacion.eliminarTecnologia(id);
        return new ResponseEntity<>("Tecnologia eliminada", HttpStatus.OK);
    }

    @GetMapping(path = "/tecnologia/lista")
    public ResponseEntity<List> listarTecnologia() {
        return new ResponseEntity<>(tecnologiaServicioImplementacion.listarTecnologia(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/tecnologia/{id}")
    public ResponseEntity<Tecnologia> buscarTecnologiaPorId(@PathVariable Long id) {
        return new ResponseEntity<>(tecnologiaServicioImplementacion.buscarTecnologiaPorId(id), HttpStatus.ACCEPTED);
    }
    
}
