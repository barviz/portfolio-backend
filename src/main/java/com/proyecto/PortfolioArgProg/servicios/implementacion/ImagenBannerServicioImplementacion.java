package com.proyecto.PortfolioArgProg.servicios.implementacion;

//import com.proyecto.PortfolioArgProg.dtos.ImagenBannerDto;
//import com.proyecto.PortfolioArgProg.entidades.ImagenBanner;
//import com.proyecto.PortfolioArgProg.entidades.Persona;
//import com.proyecto.PortfolioArgProg.repositorios.ImagenBannerRepositorio;
//import com.proyecto.PortfolioArgProg.repositorios.PersonaRepositorio;
//import com.proyecto.PortfolioArgProg.servicios.interfaces.ImagenBannerServicioInterfaz;
//import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

/**
 *
 * @author Barbara
 */
//@Service
public class ImagenBannerServicioImplementacion /*implements ImagenBannerServicioInterfaz*/ {

//    @Autowired
//    private ImagenBannerRepositorio imagenBannerRepositorio;
//
//    @Autowired
//    public PersonaRepositorio personaRepositorio;
//
//    @Override
//    public ImagenBanner crearImagenBanner(ImagenBannerDto dto) {
//
//        ImagenBanner imagenBanner = new ImagenBanner();
//
//        imagenBanner.setMime(dto.getMime());
//        imagenBanner.setNombre(dto.getNombre());
//        imagenBanner.setContenido(dto.getContenido());
//
////        Optional<Persona> personaOpt = personaRepositorio.findById(dto.getPersona());
////        if (personaOpt.isPresent()) {
////            imagenBanner.setPersona(personaOpt.get());
////        }
//
//        imagenBannerRepositorio.save(imagenBanner);
//
//        return imagenBanner;
//    }
//
//    @Override
//    public ImagenBanner actualizarImagenBanner(ImagenBannerDto dto) {
//
//        Optional<ImagenBanner> imagenBannerOpt = imagenBannerRepositorio.findById(dto.getId());
//
//        if (imagenBannerOpt.isPresent()) {
//
//            ImagenBanner imagenBanner = imagenBannerOpt.get();
//
//            imagenBanner.setMime((!dto.getMime().isEmpty()) ? dto.getMime() : imagenBanner.getMime());
//            imagenBanner.setNombre((!dto.getNombre().isEmpty()) ? dto.getNombre() : imagenBanner.getNombre());
//            imagenBanner.setContenido((dto.getContenido() != null) ? dto.getContenido() : imagenBanner.getContenido());
//            
////            Optional<Persona> personaOpt = personaRepositorio.findById(dto.getPersona());
////            if (personaOpt.isPresent()) {
////                imagenBanner.setPersona((dto.getPersona()!=null)?personaOpt.get():imagenBanner.getPersona());
////            }
//
//            imagenBannerRepositorio.save(imagenBanner);
//
//            return imagenBanner;
//        }
//
//        return null;
//    }
//
//    @Override
//    public void eliminarImagenBanner(Long id) {
//        Optional<ImagenBanner> imagenBannerOpt = imagenBannerRepositorio.findById(id);
//        if (imagenBannerOpt.isPresent()) {
//            imagenBannerRepositorio.delete(imagenBannerOpt.get());
//        }
//    }
//
//    @Override
//    public List<ImagenBanner> listarImagenBanner() {
//        List<ImagenBanner> imagenBanner = imagenBannerRepositorio.findAll();
//        return imagenBanner;
//    }
//
//    @Override
//    public ImagenBanner buscarImagenBannerPorId(Long id) {
//        Optional<ImagenBanner> imagenBannerOpt = imagenBannerRepositorio.findById(id);
//        if (imagenBannerOpt.isPresent()) {
//            return imagenBannerOpt.get();
//        }
//        return null;
//    }

}
































// /*multipartfile es el archivo donde se almacena el archivo de la foto*/
//    public ImagenBanner guardar(MultipartFile archivo) throws ErrorServicio {
//        if (archivo != null) {
//            try {
//                ImagenBanner imagen = new ImagenBanner(); //creo entidad y setteo los atrbutos
//
//                imagen.setMime(archivo.getContentType());
//                imagen.setNombre(archivo.getName());
//                imagen.setContenido(archivo.getBytes());
//
//                return imagenBannerRepositorio.save(imagen); //devuelvo la imagen persistida
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//            }
//        }
//        return null;
//    }
//
//    public ImagenBanner actualizar(Long idImagen, MultipartFile archivo) throws ErrorServicio {
//        if (archivo != null) {
//            try {
//                ImagenBanner imagen = new ImagenBanner(); //creo entidad y setteo los atrbutos
//
//                if (idImagen != null) {
//                    Optional<ImagenBanner> respuesta = imagenBannerRepositorio.findById(idImagen);
//                    if (respuesta.isPresent()) {
//                        imagen = respuesta.get();
//                    }
//                }
//                imagen.setMime(archivo.getContentType());
//                imagen.setNombre(archivo.getName());
//                imagen.setContenido(archivo.getBytes());
//
//                return imagenBannerRepositorio.save(imagen); //devuelvo la imagen persistida
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//            }
//        }
//        return null;
//    }
