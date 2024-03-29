package com.proyecto.PortfolioArgProg.controladores;

import com.proyecto.PortfolioArgProg.dtos.ProyectoDto;
import com.proyecto.PortfolioArgProg.entidades.Proyecto;
import com.proyecto.PortfolioArgProg.servicios.implementacion.ProyectoServicioImplementacion;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "https://portfoliobv-8f3dd.web.app")
public class ProyectoControlador {
    
    @Autowired
    private ProyectoServicioImplementacion proyectoServicioImplementacion;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/crear")
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody ProyectoDto dto) {
        return new ResponseEntity<Proyecto>(proyectoServicioImplementacion.crearProyecto(dto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/actualizar")
    public ResponseEntity<Proyecto> actualizarProyecto(@RequestBody ProyectoDto dto) {
        return new ResponseEntity<Proyecto>(proyectoServicioImplementacion.actualizarProyecto(dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> eliminarProyecto(@PathVariable("id") Long id) {
        proyectoServicioImplementacion.eliminarProyecto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<List> listarProyecto() {
        return new ResponseEntity<>(proyectoServicioImplementacion.listarProyecto(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/buscar/{id}")
    public ResponseEntity<Proyecto> buscarProyectoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(proyectoServicioImplementacion.buscarProyectoPorId(id), HttpStatus.ACCEPTED);
    }
    
}
