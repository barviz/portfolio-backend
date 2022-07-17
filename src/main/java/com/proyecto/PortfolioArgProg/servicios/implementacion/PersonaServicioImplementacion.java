package com.proyecto.PortfolioArgProg.servicios.implementacion;

import com.proyecto.PortfolioArgProg.dtos.PersonaDto;
import com.proyecto.PortfolioArgProg.entidades.ImagenBanner;
import com.proyecto.PortfolioArgProg.entidades.ImagenIdentidad;
import com.proyecto.PortfolioArgProg.entidades.Persona;
import com.proyecto.PortfolioArgProg.repositorios.ImagenBannerRepositorio;
import com.proyecto.PortfolioArgProg.repositorios.ImagenIdentidadRepositorio;
import com.proyecto.PortfolioArgProg.repositorios.PersonaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.PortfolioArgProg.servicios.interfaces.PersonaServicioInterfaz;
import java.util.Optional;

/**
 *
 * @author Barbara
 */
@Service
public class PersonaServicioImplementacion implements PersonaServicioInterfaz {

    @Autowired
    public PersonaRepositorio personaRepositorio;

    @Autowired
    public ImagenIdentidadRepositorio imagenIdentidadRepositorio;

    @Autowired
    public ImagenBannerRepositorio imagenBannerRepositorio;

    @Override
    public Persona crearPersona(PersonaDto dto) {

        Persona persona = new Persona();

        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());
        persona.setTitulo(dto.getTitulo());
        persona.setUbicacion(dto.getUbicacion());
        persona.setDescripcion(dto.getDescripcion());
//        persona.setImg_url_perfil(dto.getImg_url_perfil());
//        persona.setImg_url_banner(dto.getImg_url_banner());

        Optional<ImagenIdentidad> imagenIdentidadOpt = imagenIdentidadRepositorio.findById(dto.getImagenIdentidad());
        if (imagenIdentidadOpt.isPresent()) {
            persona.setImagenIdentidad(imagenIdentidadOpt.get());
        }

        Optional<ImagenBanner> imagenBannerOpt = imagenBannerRepositorio.findById(dto.getImagenBanner());
        if (imagenBannerOpt.isPresent()) {
            persona.setImagenBanner(imagenBannerOpt.get());
        }
        personaRepositorio.save(persona);

        return persona;
    }

    @Override
    public Persona actualizarPersona(PersonaDto dto) {

        Optional<Persona> personaOpt = personaRepositorio.findById(dto.getId());

        if (personaOpt.isPresent()) {

            Persona persona = personaOpt.get();

            persona.setNombre((!dto.getNombre().isEmpty()) ? dto.getNombre() : persona.getNombre());
            persona.setApellido((!dto.getApellido().isEmpty()) ? dto.getApellido() : persona.getApellido());
            persona.setTitulo((!dto.getTitulo().isEmpty()) ? dto.getTitulo() : persona.getTitulo());
            persona.setUbicacion((!dto.getUbicacion().isEmpty()) ? dto.getUbicacion() : persona.getUbicacion());
            persona.setDescripcion((!dto.getDescripcion().isEmpty()) ? dto.getDescripcion() : persona.getDescripcion());
//            persona.setImg_url_perfil((!dto.getImg_url_perfil().isEmpty()) ? dto.getImg_url_perfil() : persona.getImg_url_perfil());
//            persona.setImg_url_banner((!dto.getImg_url_banner().isEmpty()) ? dto.getImg_url_banner() : persona.getImg_url_banner());
            
//            persona.setImagenIdentidad(persona.getImagenIdentidad());
//            persona.setImagenBanner(persona.getImagenBanner());

////            persona.setImagenIdentidad((dto.getImagenIdentidadID()!=null)?dto.getImagenIdentidadID():persona.getImagenIdentidad());
////            persona.setImagenBanner((dto.getImagenBannerID()!=null)?dto.getImagenBannerID() : persona.getImagenBanner());
////
            Optional<ImagenIdentidad> imagenIdentidadOpt = imagenIdentidadRepositorio.findById(dto.getImagenIdentidad());
            if (imagenIdentidadOpt.isPresent()) {
                persona.setImagenIdentidad((dto.getImagenIdentidad()!=null)?imagenIdentidadOpt.get():persona.getImagenIdentidad());
            }

            Optional<ImagenBanner> imagenBannerOpt = imagenBannerRepositorio.findById(dto.getImagenBanner());
            if (imagenBannerOpt.isPresent()) {
                persona.setImagenBanner((dto.getImagenBanner() != null) ? imagenBannerOpt.get() : persona.getImagenBanner());
            }

                personaRepositorio.save(persona);

                return persona;
            }
            
        return null;
    }

    @Override
    public void eliminarPersona(Long id) {
        Optional<Persona> personaOpt = personaRepositorio.findById(id);
        if (personaOpt.isPresent()) {
            personaRepositorio.delete(personaOpt.get());
        }
    }

    @Override
    public List<Persona> listarPersonas() {
        List<Persona> persona = personaRepositorio.findAll();
        return persona;
    }

    @Override
    public Persona buscarPersonaPorId(Long id) {
        Optional<Persona> personaOpt = personaRepositorio.findById(id);
        if (personaOpt.isPresent()) {
            return personaOpt.get();
        }
        return null;
    }

}
















































// @Autowired
//    private PersonaRepositorio personaRepositorio;
//    
//    //vinculo los servicios de las imagenes con el servicio de usuario
//    
//    @Autowired
//    private ImagenIdentidadServicio imagenIdentidadServicio;
//    
//    @Autowired
//    private ImagenBannerServicio imagenBannerServicio;
//
//    @Transactional
//    public Persona crearPersona(MultipartFile archivo1, MultipartFile archivo2,String nombre, String apellido, String titulo, String ubicacion) throws ErrorServicio {
//
//        validaciones(nombre, apellido, titulo, ubicacion);
//
//        Persona persona = new Persona();
//        persona.setNombre(nombre);
//        persona.setApellido(apellido);
//        persona.setTitulo(titulo);
//        persona.setUbicacion(ubicacion);
//        
//        ImagenIdentidad imagenIdentidad = imagenIdentidadServicio.guardar(archivo1); //persisto una nueva imagen y la devuelvo en la variable
//        persona.setImagenIdentidad(imagenIdentidad);
//        
//        ImagenBanner imagenBanner = imagenBannerServicio.guardar(archivo2);
//        persona.setImagenBanner(imagenBanner);
//        
//        return personaRepositorio.save(persona);
//    }
//
//    @Transactional
//    public void modificarPersona(MultipartFile archivo1, MultipartFile archivo2, Long id, String nombre, String apellido, String titulo, String ubicacion) throws ErrorServicio {
//
//        validaciones(nombre, apellido, titulo, ubicacion);
//        
//        Optional<Persona> respuesta = personaRepositorio.findById(id);
//
//        if (respuesta.isPresent()) {
//            Persona persona = respuesta.get();
//
//            persona.setNombre(nombre);
//            persona.setApellido(apellido);
//            persona.setTitulo(titulo);
//            persona.setUbicacion(ubicacion);
//            
//            Long idImagenIdentidad = null;
//            if(persona.getId() != null){ //compruebo si habia una imagen guardada
//                idImagenIdentidad = persona.getImagenIdentidad().getId(); //pido la id de esa imagen
//            }
//            
//            ImagenIdentidad imagenIdentidad = imagenIdentidadServicio.actualizar(idImagenIdentidad, archivo1); //guarda la foto si no existia o la modifica
//            persona.setImagenIdentidad(imagenIdentidad); //seteo con los cambios guardados
//            
//            Long idImagenBanner = null;
//            if(persona.getId() != null){ 
//                idImagenBanner = persona.getImagenBanner().getId();
//            }
//            
//            ImagenBanner imagenBanner = imagenBannerServicio.actualizar(idImagenBanner, archivo2);
//            persona.setImagenBanner(imagenBanner);
//            
//            personaRepositorio.save(persona);
//        } else {
//            throw new ErrorServicio("No existe una persona con ese ID");
//        }
//
//    }
//
//    @Transactional(readOnly = true)
//    public List<Persona> listarPersonas() {
//        return personaRepositorio.findAll();
//    }
//
//    @Transactional(readOnly = true)
//    public Persona buscarPersonaPorId(Long id) throws ErrorServicio {
//
//        Optional<Persona> respuesta = personaRepositorio.findById(id);
//
//        if (respuesta.isPresent()) {
//            Persona persona = respuesta.get();
//
//            return persona;
//        } else {
//            throw new ErrorServicio("No se encontro la persona");
//        }
//    }
//    
//    @Transactional
//    public void eliminarPersona(Long id) throws ErrorServicio{
//     Optional <Persona> respuesta = personaRepositorio.findById(id);
//        if (respuesta.isPresent()) {
//            personaRepositorio.deleteById(id);
//        }else {
//            throw new ErrorServicio("No se encontro la persona");
//        }
//    }
//
//    
//    public void validaciones(String nombre, String apellido, String titulo, String ubicacion) throws ErrorServicio {
//
//        if (nombre == null || nombre.trim().isEmpty()) {
//            throw new ErrorServicio("Nombre no puede estar vacío ni ser null");
//        }
//        if (apellido == null || apellido.trim().isEmpty()) {
//            throw new ErrorServicio("Apellido no puede estar vacío ni ser null");
//        }
//        if (titulo == null || titulo.trim().isEmpty()) {
//            throw new ErrorServicio("Título no puede estar vacío ni ser null");
//        }
//        if (ubicacion == null || ubicacion.trim().isEmpty()) {
//            throw new ErrorServicio("Ubicación no puede estar vacío ni ser null");
//        }
//    }
//    @Override
//    public void editarPersona(Long id, Persona persona) {
//
//        Optional<Persona> respuesta = personaRepositorio.findById(id);
//
//        if (respuesta.isPresent()) {
//            persona = respuesta.get();
//
//            persona.setNombre(persona.getNombre());
//            persona.setApellido(persona.getApellido());
//            persona.setTitulo(persona.getTitulo());
//            persona.setUbicacion(persona.getUbicacion());
//            persona.setImagenPerfil(persona.getImagenPerfil());
//            persona.setImagenBanner(persona.getImagenBanner());
//        }
//    }
