package com.proyecto.PortfolioArgProg.controladores;

import com.proyecto.PortfolioArgProg.dtos.PersonaDto;
import com.proyecto.PortfolioArgProg.entidades.Persona;
import com.proyecto.PortfolioArgProg.servicios.implementacion.PersonaServicioImplementacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Barbara
 */
@RestController
public class PersonaControlador {

    @Autowired
    private PersonaServicioImplementacion personaServicioImplementacion;

    @PostMapping(path = "/persona")
    public ResponseEntity<Persona> crearPersona(@RequestBody PersonaDto dto) {
        return new ResponseEntity<Persona>(personaServicioImplementacion.crearPersona(dto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/persona")
    public ResponseEntity<Persona> actualizarPersona(@RequestBody PersonaDto dto) {
        return new ResponseEntity<Persona>(personaServicioImplementacion.actualizarPersona(dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/persona/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable Long id) {
        personaServicioImplementacion.eliminarPersona(id);
        return new ResponseEntity<>("Persona eliminada", HttpStatus.OK);
    }

    @GetMapping(path = "/personas/lista")
    public ResponseEntity<List> listarPersonas() {
        return new ResponseEntity<>(personaServicioImplementacion.listarPersonas(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/persona/{id}")
    public ResponseEntity<Persona> buscarPersonaPorId(@PathVariable Long id) {
        return new ResponseEntity<>(personaServicioImplementacion.buscarPersonaPorId(id), HttpStatus.ACCEPTED);
    }

}












































//@GetMapping("")
//    public ResponseEntity<?> getAll() {
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(personaServicio.listarPersonas());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getOne(@PathVariable Long id) {
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(personaServicio.buscarPersonaPorId(id));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
//        }
//    }
//
//    @PostMapping("")
//    public ResponseEntity<Persona> save(@RequestBody Persona entity) {
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(personaServicio.crearPersona(archivo1, archivo2, nombre, apellido, titulo, ubicacion));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
//        }
//    }
//    
//    
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Persona entity) {
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(personaServicio.modificarPersona(archivo1, archivo2, id, nombre, apellido, titulo, ubicacion));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable Long id) {
//        try {
//            personaServicio.eliminarPersona(id);
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
//        }
//
//    }
//    @PostMapping("/new/persona")
//    public String agregarPersona(@RequestBody Persona persona) {
//        ipersonaServicio.crearPersona(persona);
//        return "La persona fue creada correctamente";
//    }
//    @PutMapping("/edit/{id}")
//    public Persona editarPersona(@PathVariable Long id, @RequestParam("nombre") String newNombre, @RequestParam("apellido") String newApellido, @RequestParam("titulo") String newTitulo, @RequestParam("ubicacion") String newUbicacion, @RequestParam("imagenPerfil") String newImagenPerfil, @RequestParam("imagenBanner") String newImagenBanner) {
//        
//        Persona persona = ipersonaServicio.buscarPersonaPorId(id);
//        
//        persona.setNombre(newNombre);
//        persona.setApellido(newApellido);
//        persona.setTitulo(newTitulo);
//        persona.setUbicacion(newUbicacion);
//        persona.setImagenPerfil(newImagenPerfil);
//        persona.setImagenBanner(newImagenBanner);
//        
//        ipersonaServicio.crearPersona(persona);
//        return persona;
//    }
//    @DeleteMapping("/delete/{id}")
//    public String borrarPersona(@PathVariable Long id) {
//        ipersonaServicio.eliminarPersona(id);
//        return "La persona fue eliminada correctamente";
//    }
//
//    @GetMapping("/ver/personas")
//    public List<Persona> verPersonas() {
//        return ipersonaServicio.listarPersonas();
//    }
//
//    @GetMapping("/buscar/{id}")
//    public Persona buscarPersona(@PathVariable Long id) {
//        return ipersonaServicio.buscarPersonaPorId(id);
//    }
