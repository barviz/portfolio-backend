package com.proyecto.PortfolioArgProg.controladores;

import com.proyecto.PortfolioArgProg.dtos.PersonaResumenDto;
import com.proyecto.PortfolioArgProg.entidades.PersonaResumen;
import com.proyecto.PortfolioArgProg.servicios.implementacion.PersonaResumenServicioImplementacion;
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
@RequestMapping("/persona-resumen")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaResumenControlador {
    
    @Autowired
    private PersonaResumenServicioImplementacion personaResumenServicioImplementacion;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/crear")
    public ResponseEntity<PersonaResumen> crearPersonaResumen(@RequestBody PersonaResumenDto dto) {
        return new ResponseEntity<PersonaResumen>(personaResumenServicioImplementacion.crearPersonaResumen(dto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/actualizar")
    public ResponseEntity<PersonaResumen> actualizarPersonaResumen(@RequestBody PersonaResumenDto dto) {
        return new ResponseEntity<PersonaResumen>(personaResumenServicioImplementacion.actualizarPersonaResumen(dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> eliminarPersonaResumen(@PathVariable("id") Long id) {
        personaResumenServicioImplementacion.eliminarPersonaResumen(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<List> listarPersonaResumen() {
        return new ResponseEntity<>(personaResumenServicioImplementacion.listarPersonaResumen(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/buscar/{id}")
    public ResponseEntity<PersonaResumen> buscarPersonaResumenPorId(@PathVariable Long id) {
        return new ResponseEntity<>(personaResumenServicioImplementacion.buscarPersonaResumenPorId(id), HttpStatus.ACCEPTED);
    }
    
}
