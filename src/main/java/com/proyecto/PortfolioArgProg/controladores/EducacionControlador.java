package com.proyecto.PortfolioArgProg.controladores;

import com.proyecto.PortfolioArgProg.dtos.EducacionDto;
import com.proyecto.PortfolioArgProg.entidades.Educacion;
import com.proyecto.PortfolioArgProg.servicios.implementacion.EducacionServicioImplementacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Barbara
 */
@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://portfolio-blv.web.app")
public class EducacionControlador {
    
    @Autowired
    private EducacionServicioImplementacion educacionServicioImplementacion;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/crear")
    public ResponseEntity<Educacion> crearEducacion(@RequestBody EducacionDto dto) {
        return new ResponseEntity<Educacion>(educacionServicioImplementacion.crearEducacion(dto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/actualizar")
    public ResponseEntity<Educacion> actualizarEducacion(@RequestBody EducacionDto dto) {
        return new ResponseEntity<Educacion>(educacionServicioImplementacion.actualizarEducacion(dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> eliminarEducacion(@PathVariable("id") Long id) {
        educacionServicioImplementacion.eliminarEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<List> listarEducacion() {
        return new ResponseEntity<>(educacionServicioImplementacion.listarEducacion(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/buscar/{id}")
    public ResponseEntity<Educacion> buscarEducacionPorId(@PathVariable Long id) {
        return new ResponseEntity<>(educacionServicioImplementacion.buscarEducacionPorId(id), HttpStatus.ACCEPTED);
    }
    
}
