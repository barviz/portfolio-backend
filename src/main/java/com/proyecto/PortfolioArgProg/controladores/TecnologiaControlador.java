package com.proyecto.PortfolioArgProg.controladores;

import com.proyecto.PortfolioArgProg.dtos.TecnologiaDto;
import com.proyecto.PortfolioArgProg.entidades.Tecnologia;
import com.proyecto.PortfolioArgProg.servicios.implementacion.TecnologiaServicioImplementacion;
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
@RequestMapping("/tecnologia")
@CrossOrigin(origins = "http://localhost:4200")
public class TecnologiaControlador {
    
    @Autowired
    private TecnologiaServicioImplementacion tecnologiaServicioImplementacion;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/crear")
    public ResponseEntity<Tecnologia> crearTecnologia(@RequestBody TecnologiaDto dto) {
        return new ResponseEntity<Tecnologia>(tecnologiaServicioImplementacion.crearTecnologia(dto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/actualizar")
    public ResponseEntity<Tecnologia> actualizarTecnologia(@RequestBody TecnologiaDto dto) {
        return new ResponseEntity<Tecnologia>(tecnologiaServicioImplementacion.actualizarTecnologia(dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> eliminarTecnologia(@PathVariable("id") Long id) {
        tecnologiaServicioImplementacion.eliminarTecnologia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<List> listarTecnologia() {
        return new ResponseEntity<>(tecnologiaServicioImplementacion.listarTecnologia(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/buscar/{id}")
    public ResponseEntity<Tecnologia> buscarTecnologiaPorId(@PathVariable Long id) {
        return new ResponseEntity<>(tecnologiaServicioImplementacion.buscarTecnologiaPorId(id), HttpStatus.ACCEPTED);
    }
    
}
