package com.proyecto.PortfolioArgProg.controladores;

import com.proyecto.PortfolioArgProg.dtos.HabilidadDto;
import com.proyecto.PortfolioArgProg.entidades.Habilidad;
import com.proyecto.PortfolioArgProg.servicios.implementacion.HabilidadServicioImplementacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Barbara
 */
@RestController
@RequestMapping("/habilidad")
@CrossOrigin(origins = "https://portfolio-blv.web.app")
public class HabilidadControlador {
    
    @Autowired
    private HabilidadServicioImplementacion habilidadServicioImplementacion;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/crear")
    public ResponseEntity<Habilidad> crearHabilidad(@RequestBody HabilidadDto dto) {
        return new ResponseEntity<Habilidad>(habilidadServicioImplementacion.crearHabilidad(dto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/actualizar")
    public ResponseEntity<Habilidad> actualizarHabilidad(@RequestBody HabilidadDto dto) {
        return new ResponseEntity<Habilidad>(habilidadServicioImplementacion.actualizarHabilidad(dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> eliminarHabilidad(@PathVariable("id") Long id) {
        habilidadServicioImplementacion.eliminarHabilidad(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<List> listarHabilidad() {
        return new ResponseEntity<>(habilidadServicioImplementacion.listarHabilidad(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/buscar/{id}")
    public ResponseEntity<Habilidad> buscarHabilidadPorId(@PathVariable Long id) {
        return new ResponseEntity<>(habilidadServicioImplementacion.buscarHabilidadPorId(id), HttpStatus.ACCEPTED);
    }
    
}
