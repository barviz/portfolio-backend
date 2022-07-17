package com.proyecto.PortfolioArgProg.controladores;

import com.proyecto.PortfolioArgProg.dtos.ExperienciaDto;
import com.proyecto.PortfolioArgProg.entidades.Experiencia;
import com.proyecto.PortfolioArgProg.servicios.implementacion.ExperienciaServicioImplementacion;
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
public class ExperienciaControlador {
    
    @Autowired
    private ExperienciaServicioImplementacion experienciaServicioImplementacion;

    @PostMapping(path = "/experiencia")
    public ResponseEntity<Experiencia> crearExperiencia(@RequestBody ExperienciaDto dto) {
        return new ResponseEntity<Experiencia>(experienciaServicioImplementacion.crearExperiencia(dto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/experiencia")
    public ResponseEntity<Experiencia> actualizarExperiencia(@RequestBody ExperienciaDto dto) {
        return new ResponseEntity<Experiencia>(experienciaServicioImplementacion.actualizarExperiencia(dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/experiencia/{id}")
    public ResponseEntity<String> eliminarExperiencia(@PathVariable Long id) {
        experienciaServicioImplementacion.eliminarExperiencia(id);
        return new ResponseEntity<>("Experiencia eliminada", HttpStatus.OK);
    }

    @GetMapping(path = "/experiencia/lista")
    public ResponseEntity<List> listarExperiencia() {
        return new ResponseEntity<>(experienciaServicioImplementacion.listarExperiencia(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/experiencia/{id}")
    public ResponseEntity<Experiencia> buscarExperienciaPorId(@PathVariable Long id) {
        return new ResponseEntity<>(experienciaServicioImplementacion.buscarExperienciaPorId(id), HttpStatus.ACCEPTED);
    }
    
}
