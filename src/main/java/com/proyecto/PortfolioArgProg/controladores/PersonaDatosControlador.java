package com.proyecto.PortfolioArgProg.controladores;

import com.proyecto.PortfolioArgProg.dtos.PersonaDatosDto;
import com.proyecto.PortfolioArgProg.entidades.PersonaDatos;
import com.proyecto.PortfolioArgProg.servicios.implementacion.PersonaDatosServicioImplementacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @author Barbara
 */
@RestController
@RequestMapping("/persona-datos")
@CrossOrigin(origins = "https://portfolio-blv.web.app")
public class PersonaDatosControlador {

    @Autowired
    private PersonaDatosServicioImplementacion personaDatosServicioImplementacion;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/crear")
    public ResponseEntity<PersonaDatos> crearPersonaDatos(@RequestBody PersonaDatosDto dto) {
        return new ResponseEntity<PersonaDatos>(personaDatosServicioImplementacion.crearPersonaDatos(dto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/actualizar")
    public ResponseEntity<PersonaDatos> actualizarPersonaDatos(@RequestBody PersonaDatosDto dto) {
        return new ResponseEntity<PersonaDatos>(personaDatosServicioImplementacion.actualizarPersonaDatos(dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable("id") Long id) {
        personaDatosServicioImplementacion.eliminarPersonaDatos(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<List> listarPersonaDatos() {
        return new ResponseEntity<>(personaDatosServicioImplementacion.listarPersonaDatos(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/buscar/{id}")
    public ResponseEntity<PersonaDatos> buscarPersonaDatosPorId(@PathVariable Long id) {
        return new ResponseEntity<>(personaDatosServicioImplementacion.buscarPersonaDatosPorId(id), HttpStatus.ACCEPTED);
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
//    public ResponseEntity<Persona> save(@RequestBody PersonaDatos entity) {
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
//    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PersonaDatos entity) {
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
//    public String agregarPersona(@RequestBody PersonaDatos persona) {
//        ipersonaServicio.crearPersona(persona);
//        return "La persona fue creada correctamente";
//    }
//    @PutMapping("/edit/{id}")
//    public PersonaDatos editarPersona(@PathVariable Long id, @RequestParam("nombre") String newNombre, @RequestParam("apellido") String newApellido, @RequestParam("titulo") String newTitulo, @RequestParam("ubicacion") String newUbicacion, @RequestParam("imagenPerfil") String newImagenPerfil, @RequestParam("imagenBanner") String newImagenBanner) {
//        
//        PersonaDatos persona = ipersonaServicio.buscarPersonaPorId(id);
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
//    public PersonaDatos buscarPersona(@PathVariable Long id) {
//        return ipersonaServicio.buscarPersonaPorId(id);
//    }
