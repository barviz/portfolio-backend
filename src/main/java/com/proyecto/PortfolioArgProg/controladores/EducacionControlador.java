package com.proyecto.PortfolioArgProg.controladores;

import com.proyecto.PortfolioArgProg.dtos.EducacionDto;
import com.proyecto.PortfolioArgProg.entidades.Educacion;
import com.proyecto.PortfolioArgProg.servicios.implementacion.EducacionServicioImplementacion;
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
public class EducacionControlador {
    
    @Autowired
    private EducacionServicioImplementacion educacionServicioImplementacion;

    @PostMapping(path = "/educacion")
    public ResponseEntity<Educacion> crearEducacion(@RequestBody EducacionDto dto) {
        return new ResponseEntity<Educacion>(educacionServicioImplementacion.crearEducacion(dto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/educacion")
    public ResponseEntity<Educacion> actualizarEducacion(@RequestBody EducacionDto dto) {
        return new ResponseEntity<Educacion>(educacionServicioImplementacion.actualizarEducacion(dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/educacion/{id}")
    public ResponseEntity<String> eliminarEducacion(@PathVariable Long id) {
        educacionServicioImplementacion.eliminarEducacion(id);
        return new ResponseEntity<>("Educacion eliminada", HttpStatus.OK);
    }

    @GetMapping(path = "/educacion/lista")
    public ResponseEntity<List> listarEducacion() {
        return new ResponseEntity<>(educacionServicioImplementacion.listarEducacion(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/educacion/{id}")
    public ResponseEntity<Educacion> buscarEducacionPorId(@PathVariable Long id) {
        return new ResponseEntity<>(educacionServicioImplementacion.buscarEducacionPorId(id), HttpStatus.ACCEPTED);
    }
    
}
