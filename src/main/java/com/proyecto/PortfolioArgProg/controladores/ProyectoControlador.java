package com.proyecto.PortfolioArgProg.controladores;

import com.proyecto.PortfolioArgProg.dtos.ProyectoDto;
import com.proyecto.PortfolioArgProg.entidades.Proyecto;
import com.proyecto.PortfolioArgProg.servicios.implementacion.ProyectoServicioImplementacion;
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
public class ProyectoControlador {
    
    @Autowired
    private ProyectoServicioImplementacion proyectoServicioImplementacion;

    @PostMapping(path = "/proyecto")
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody ProyectoDto dto) {
        return new ResponseEntity<Proyecto>(proyectoServicioImplementacion.crearProyecto(dto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/proyecto")
    public ResponseEntity<Proyecto> actualizarProyecto(@RequestBody ProyectoDto dto) {
        return new ResponseEntity<Proyecto>(proyectoServicioImplementacion.actualizarProyecto(dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/proyecto/{id}")
    public ResponseEntity<String> eliminarProyecto(@PathVariable Long id) {
        proyectoServicioImplementacion.eliminarProyecto(id);
        return new ResponseEntity<>("Proyecto eliminado", HttpStatus.OK);
    }

    @GetMapping(path = "/proyecto/lista")
    public ResponseEntity<List> listarProyecto() {
        return new ResponseEntity<>(proyectoServicioImplementacion.listarProyecto(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/proyecto/{id}")
    public ResponseEntity<Proyecto> buscarProyectoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(proyectoServicioImplementacion.buscarProyectoPorId(id), HttpStatus.ACCEPTED);
    }
    
}
