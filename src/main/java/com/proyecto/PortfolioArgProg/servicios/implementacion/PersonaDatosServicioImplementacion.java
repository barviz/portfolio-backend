package com.proyecto.PortfolioArgProg.servicios.implementacion;

import com.proyecto.PortfolioArgProg.dtos.PersonaDatosDto;
import com.proyecto.PortfolioArgProg.entidades.PersonaDatos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.proyecto.PortfolioArgProg.repositorios.PersonaDatosRepositorio;
import com.proyecto.PortfolioArgProg.servicios.interfaces.PersonaDatosServicioInterfaz;

/**
 *
 * @author Barbara
 */
@Service
public class PersonaDatosServicioImplementacion implements PersonaDatosServicioInterfaz {

    @Autowired
    public PersonaDatosRepositorio personaDatosRepositorio;

//    @Autowired
//    public ImagenIdentidadRepositorio imagenIdentidadRepositorio;
//
//    @Autowired
//    public ImagenBannerRepositorio imagenBannerRepositorio;

    @Override
    public PersonaDatos crearPersonaDatos(PersonaDatosDto dto) {

        PersonaDatos personaDatos = new PersonaDatos();

        personaDatos.setNombre(dto.getNombre());
        personaDatos.setApellido(dto.getApellido());
        personaDatos.setTitulo(dto.getTitulo());
        personaDatos.setUbicacion(dto.getUbicacion());
        personaDatos.setImg_url_perfil(dto.getImg_url_perfil());
        personaDatos.setImg_url_banner(dto.getImg_url_banner());

//        Optional<ImagenIdentidad> imagenIdentidadOpt = imagenIdentidadRepositorio.findById(dto.getImagenIdentidad());
//        if (imagenIdentidadOpt.isPresent()) {
//            persona.setImagenIdentidad(imagenIdentidadOpt.get());
//        }
//
//        Optional<ImagenBanner> imagenBannerOpt = imagenBannerRepositorio.findById(dto.getImagenBanner());
//        if (imagenBannerOpt.isPresent()) {
//            persona.setImagenBanner(imagenBannerOpt.get());
//        }
        personaDatosRepositorio.save(personaDatos);

        return personaDatos;
    }

    @Override
    public PersonaDatos actualizarPersonaDatos(PersonaDatosDto dto) {

        Optional<PersonaDatos> personaDatosOpt = personaDatosRepositorio.findById(dto.getId());

        if (personaDatosOpt.isPresent()) {

            PersonaDatos personaDatos = personaDatosOpt.get();

            personaDatos.setNombre((!dto.getNombre().isEmpty()) ? dto.getNombre() : personaDatos.getNombre());
            personaDatos.setApellido((!dto.getApellido().isEmpty()) ? dto.getApellido() : personaDatos.getApellido());
            personaDatos.setTitulo((!dto.getTitulo().isEmpty()) ? dto.getTitulo() : personaDatos.getTitulo());
            personaDatos.setUbicacion((!dto.getUbicacion().isEmpty()) ? dto.getUbicacion() : personaDatos.getUbicacion());
            personaDatos.setImg_url_perfil((!dto.getImg_url_perfil().isEmpty()) ? dto.getImg_url_perfil() : personaDatos.getImg_url_perfil());
            personaDatos.setImg_url_banner((!dto.getImg_url_banner().isEmpty()) ? dto.getImg_url_banner() : personaDatos.getImg_url_banner());
            
//            persona.setImagenIdentidad(persona.getImagenIdentidad());
//            persona.setImagenBanner(persona.getImagenBanner());

////            persona.setImagenIdentidad((dto.getImagenIdentidadID()!=null)?dto.getImagenIdentidadID():persona.getImagenIdentidad());
////            persona.setImagenBanner((dto.getImagenBannerID()!=null)?dto.getImagenBannerID() : persona.getImagenBanner());
////
//            Optional<ImagenIdentidad> imagenIdentidadOpt = imagenIdentidadRepositorio.findById(dto.getImagenIdentidad());
//            if (imagenIdentidadOpt.isPresent()) {
//                persona.setImagenIdentidad((dto.getImagenIdentidad()!=null)?imagenIdentidadOpt.get():persona.getImagenIdentidad());
//            }

//            Optional<ImagenBanner> imagenBannerOpt = imagenBannerRepositorio.findById(dto.getImagenBanner());
//            if (imagenBannerOpt.isPresent()) {
//                persona.setImagenBanner((dto.getImagenBanner() != null) ? imagenBannerOpt.get() : persona.getImagenBanner());
//            }

                personaDatosRepositorio.save(personaDatos);

                return personaDatos;
            }
            
        return null;
    }

    @Override
    public void eliminarPersonaDatos(Long id) {
        Optional<PersonaDatos> personaDatosOpt = personaDatosRepositorio.findById(id);
        if (personaDatosOpt.isPresent()) {
            personaDatosRepositorio.delete(personaDatosOpt.get());
        }
    }

    @Override
    public List<PersonaDatos> listarPersonaDatos() {
        List<PersonaDatos> personaDatos = personaDatosRepositorio.findAll();
        return personaDatos;
    }

    @Override
    public PersonaDatos buscarPersonaDatosPorId(Long id) {
        Optional<PersonaDatos> personaDatosOpt = personaDatosRepositorio.findById(id);
        if (personaDatosOpt.isPresent()) {
            return personaDatosOpt.get();
        }
        return null;
    }

}
















































// @Autowired
//    private PersonaDatosRepositorio personaRepositorio;
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
//    public PersonaDatos crearPersona(MultipartFile archivo1, MultipartFile archivo2,String nombre, String apellido, String titulo, String ubicacion) throws ErrorServicio {
//
//        validaciones(nombre, apellido, titulo, ubicacion);
//
//        PersonaDatos persona = new PersonaDatos();
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
//            PersonaDatos persona = respuesta.get();
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
//    public PersonaDatos buscarPersonaPorId(Long id) throws ErrorServicio {
//
//        Optional<Persona> respuesta = personaRepositorio.findById(id);
//
//        if (respuesta.isPresent()) {
//            PersonaDatos persona = respuesta.get();
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
//    public void editarPersona(Long id, PersonaDatos persona) {
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
