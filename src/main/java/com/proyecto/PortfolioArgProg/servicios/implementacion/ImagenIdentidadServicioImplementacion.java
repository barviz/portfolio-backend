package com.proyecto.PortfolioArgProg.servicios.implementacion;

import com.proyecto.PortfolioArgProg.dtos.ImagenIdentidadDto;
import com.proyecto.PortfolioArgProg.entidades.ImagenIdentidad;
import com.proyecto.PortfolioArgProg.entidades.Persona;
import com.proyecto.PortfolioArgProg.repositorios.ImagenIdentidadRepositorio;
import com.proyecto.PortfolioArgProg.repositorios.PersonaRepositorio;
import com.proyecto.PortfolioArgProg.servicios.interfaces.ImagenIdentidadServicioInterfaz;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Barbara
 */
@Service
public class ImagenIdentidadServicioImplementacion implements ImagenIdentidadServicioInterfaz {

    @Autowired
    private ImagenIdentidadRepositorio imagenIdentidadRepositorio;
    
    @Autowired
    public PersonaRepositorio personaRepositorio;

    @Override
    public ImagenIdentidad crearImagenIdentidad(ImagenIdentidadDto dto) {

        ImagenIdentidad imagenIdentidad = new ImagenIdentidad();

        imagenIdentidad.setMime(dto.getMime());
        imagenIdentidad.setNombre(dto.getNombre());
        imagenIdentidad.setContenido(dto.getContenido());
        
//        Optional<Persona> personaOpt = personaRepositorio.findById(dto.getPersona());
//        if (personaOpt.isPresent()) {
//            imagenIdentidad.setPersona(personaOpt.get());
//        }

        imagenIdentidadRepositorio.save(imagenIdentidad);

        return imagenIdentidad;
    }

    @Override
    public ImagenIdentidad actualizarImagenIdentidad(ImagenIdentidadDto dto) {

        Optional<ImagenIdentidad> imagenIdentidadOpt = imagenIdentidadRepositorio.findById(dto.getId());

        if (imagenIdentidadOpt.isPresent()) {

            ImagenIdentidad imagenIdentidad = imagenIdentidadOpt.get();

            imagenIdentidad.setMime((!dto.getMime().isEmpty()) ? dto.getMime() : imagenIdentidad.getMime());
            imagenIdentidad.setNombre((!dto.getNombre().isEmpty()) ? dto.getNombre() : imagenIdentidad.getNombre());
            imagenIdentidad.setContenido((dto.getContenido() != null) ? dto.getContenido() : imagenIdentidad.getContenido());
           
//            Optional<Persona> personaOpt = personaRepositorio.findById(dto.getPersona());
//            if (personaOpt.isPresent()) {
//                imagenIdentidad.setPersona((dto.getPersona()!=null)?personaOpt.get():imagenIdentidad.getPersona());
//            }

            imagenIdentidadRepositorio.save(imagenIdentidad);

            return imagenIdentidad;
        }

        return null;
    }

    @Override
    public void eliminarImagenIdentidad(Long id) {
        Optional<ImagenIdentidad> imagenIdentidadOpt = imagenIdentidadRepositorio.findById(id);
        if (imagenIdentidadOpt.isPresent()) {
            imagenIdentidadRepositorio.delete(imagenIdentidadOpt.get());
        }
    }

    @Override
    public List<ImagenIdentidad> listarImagenIdentidad() {
        List<ImagenIdentidad> imagenIdentidad = imagenIdentidadRepositorio.findAll();
        return imagenIdentidad;
    }

    @Override
    public ImagenIdentidad buscarImagenIdentidadPorId(Long id) {
        Optional<ImagenIdentidad> imagenIdentidadOpt = imagenIdentidadRepositorio.findById(id);
        if (imagenIdentidadOpt.isPresent()) {
            return imagenIdentidadOpt.get();
        }
        return null;
    }

}


































///*multipartfile es el archivo donde se almacena el archivo de la foto*/
//    public ImagenIdentidad guardar(MultipartFile archivo) throws ErrorServicio {
//        if (archivo != null) {
//            try {
//                ImagenIdentidad imagen = new ImagenIdentidad(); //creo entidad y setteo los atrbutos
//
//                imagen.setMime(archivo.getContentType());
//                imagen.setNombre(archivo.getName());
//                imagen.setContenido(archivo.getBytes());
//
//                return imagenIdentidadRepositorio.save(imagen); //devuelvo la imagen persistida
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//            }
//        }
//        return null;
//    }
//
//    public ImagenIdentidad actualizar(Long idImagen, MultipartFile archivo) throws ErrorServicio {
//        if (archivo != null) {
//            try {
//                ImagenIdentidad imagen = new ImagenIdentidad(); //creo entidad y setteo los atrbutos
//
//                if (idImagen != null) {
//                    Optional<ImagenIdentidad> respuesta = imagenIdentidadRepositorio.findById(idImagen);
//                    if (respuesta.isPresent()) {
//                        imagen = respuesta.get();
//                    }
//                }
//                imagen.setMime(archivo.getContentType());
//                imagen.setNombre(archivo.getName());
//                imagen.setContenido(archivo.getBytes());
//
//                return imagenIdentidadRepositorio.save(imagen); //devuelvo la imagen persistida
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//            }
//        }
//        return null;
//    }
