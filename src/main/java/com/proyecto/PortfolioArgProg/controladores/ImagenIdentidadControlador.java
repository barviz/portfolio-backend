package com.proyecto.PortfolioArgProg.controladores;

import com.proyecto.PortfolioArgProg.dtos.ImagenIdentidadDto;
import com.proyecto.PortfolioArgProg.entidades.ImagenIdentidad;
import com.proyecto.PortfolioArgProg.servicios.implementacion.ImagenIdentidadServicioImplementacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Barbara
 */
@RestController
public class ImagenIdentidadControlador {
    
    @Autowired
    private ImagenIdentidadServicioImplementacion imagenIdentidadServicioImplementacion;

    @PostMapping(path = "/img-identidad")
    public ResponseEntity<ImagenIdentidad> crearImagenIdentidad(@RequestBody ImagenIdentidadDto dto) {
        return new ResponseEntity<ImagenIdentidad>(imagenIdentidadServicioImplementacion.crearImagenIdentidad(dto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/img-identidad")
    public ResponseEntity<ImagenIdentidad> actualizarImagenIdentidad(@RequestBody ImagenIdentidadDto dto) {
        return new ResponseEntity<ImagenIdentidad>(imagenIdentidadServicioImplementacion.actualizarImagenIdentidad(dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/img-identidad/{id}")
    public ResponseEntity<String> eliminarImagenIdentidad(@PathVariable Long id) {
        imagenIdentidadServicioImplementacion.eliminarImagenIdentidad(id);
        return new ResponseEntity<>("ImagenIdentidad eliminada", HttpStatus.OK);
    }

    @GetMapping(path = "/img-identidad/lista")
    public ResponseEntity<List> listarImagenIdentidad() {
        return new ResponseEntity<>(imagenIdentidadServicioImplementacion.listarImagenIdentidad(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/img-identidad/{id}")
    public ResponseEntity<ImagenIdentidad> buscarImagenIdentidadPorId(@PathVariable Long id) {
        return new ResponseEntity<>(imagenIdentidadServicioImplementacion.buscarImagenIdentidadPorId(id), HttpStatus.ACCEPTED);
    }
    
}
