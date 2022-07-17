package com.proyecto.PortfolioArgProg.servicios.implementacion;

import com.proyecto.PortfolioArgProg.dtos.EducacionDto;
import com.proyecto.PortfolioArgProg.entidades.Educacion;
import com.proyecto.PortfolioArgProg.entidades.ImagenIdentidad;
import com.proyecto.PortfolioArgProg.repositorios.EducacionRepositorio;
import com.proyecto.PortfolioArgProg.repositorios.ImagenIdentidadRepositorio;
import com.proyecto.PortfolioArgProg.servicios.interfaces.EducacionServicioInterfaz;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Barbara
 */
@Service
public class EducacionServicioImplementacion implements EducacionServicioInterfaz {

    @Autowired
    public EducacionRepositorio educacionRepositorio;

    @Autowired
    public ImagenIdentidadRepositorio imagenIdentidadRepositorio;

    @Override
    public Educacion crearEducacion(EducacionDto dto) {

        Educacion educacion = new Educacion();

        educacion.setTitulo(dto.getTitulo());
        educacion.setInstitucion(dto.getInstitucion());
        educacion.setAnio_inicio(dto.getAnio_inicio());
        educacion.setAnio_fin(dto.getAnio_fin());
//        educacion.setImg_url(dto.getImg_url());

        Optional<ImagenIdentidad> imagenIdentidadOpt = imagenIdentidadRepositorio.findById(dto.getImagenIdentidad());
        if (imagenIdentidadOpt.isPresent()) {
            educacion.setImagenIdentidad(imagenIdentidadOpt.get());
        }

        educacionRepositorio.save(educacion);

        return educacion;
    }

    @Override
    public Educacion actualizarEducacion(EducacionDto dto) {

        Optional<Educacion> educacionOpt = educacionRepositorio.findById(dto.getId());

        if (educacionOpt.isPresent()) {

            Educacion educacion = educacionOpt.get();

            educacion.setTitulo((!dto.getTitulo().isEmpty()) ? dto.getTitulo() : educacion.getTitulo());
            educacion.setInstitucion((!dto.getInstitucion().isEmpty()) ? dto.getInstitucion() : educacion.getInstitucion());
            educacion.setAnio_inicio((dto.getAnio_inicio() != null) ? dto.getAnio_inicio() : educacion.getAnio_inicio());
            educacion.setAnio_fin((dto.getAnio_fin() != null) ? dto.getAnio_fin() : educacion.getAnio_fin());
//            educacion.setImg_url((!dto.getImg_url().isEmpty()) ? dto.getImg_url() : educacion.getImg_url());

            Optional<ImagenIdentidad> imagenIdentidadOpt = imagenIdentidadRepositorio.findById(dto.getImagenIdentidad());
            if (imagenIdentidadOpt.isPresent()) {
                educacion.setImagenIdentidad((dto.getImagenIdentidad() != null) ? imagenIdentidadOpt.get() : educacion.getImagenIdentidad());
            }
            educacionRepositorio.save(educacion);

            return educacion;
        }

        return null;
    }

    @Override
    public void eliminarEducacion(Long id) {
        Optional<Educacion> educacionOpt = educacionRepositorio.findById(id);
        if (educacionOpt.isPresent()) {
            educacionRepositorio.delete(educacionOpt.get());
        }
    }

    @Override
    public List<Educacion> listarEducacion() {
        List<Educacion> educacion = educacionRepositorio.findAll();
        return educacion;
    }

    @Override
    public Educacion buscarEducacionPorId(Long id) {
        Optional<Educacion> educacionOpt = educacionRepositorio.findById(id);
        if (educacionOpt.isPresent()) {
            return educacionOpt.get();
        }
        return null;
    }
}

//    @Autowired
//    private PersonaRepositorio personaRepositorio;
//
//    @Autowired
//    private EducacionRepositorio educacionRepositorio; //persisto 
//
//    //vinculo los servicios de las imagenes con el servicio de usuario
//    @Autowired
//    private ImagenIdentidadServicioImplementacion imagenIdentidadServicio;
//
//    @Transactional
//    public void crearEducacion(MultipartFile archivo1, Long idPersona, String titulo, String institucion, Integer anio_inicio, Integer anio_fin) throws ErrorServicio {
//
//        Persona persona = personaRepositorio.findById(idPersona).get();
//
//        validaciones(titulo, institucion, anio_inicio, anio_fin);
//
//        Educacion educacion = new Educacion(); //creo un estudio y seteo atributos
//
//        educacion.setTitulo(titulo);
//        educacion.setInstitucion(institucion);
//        educacion.setAnio_inicio(anio_inicio);
//        educacion.setAnio_fin(anio_fin);
//        educacion.setPersona(persona);
//
//        ImagenIdentidad imagenIdentidad = imagenIdentidadServicio.guardar(archivo1); //persisto una nueva imagen y la devuelvo en la variable
//        educacion.setImagenIdentidad(imagenIdentidad);
//
//        educacionRepositorio.save(educacion);
//    }
//
//    @Transactional
//    public void modificarEducacion(MultipartFile archivo1, Long idPersona, Long idEducacion, String titulo, String institucion, Integer anio_inicio, Integer anio_fin) throws ErrorServicio { //recibo el id de la persona que quiere realizar los cambios
//
//        validaciones(titulo, institucion, anio_inicio, anio_fin);
//
//        Optional<Educacion> respuesta = educacionRepositorio.findById(idEducacion); //en la base de datos busca un estudio que tenga ese id
//
//        if (respuesta.isPresent()) {
//            Educacion educacion = respuesta.get(); //trae los datos de educacion con ese id
//
//            if (educacion.getPersona().getId().equals(idPersona)) { //verifico que ese estudio pertenezca a la persona
//                //si es así se permiten los cambios
//
//                educacion.setTitulo(titulo);
//                educacion.setInstitucion(institucion);
//                educacion.setAnio_inicio(anio_inicio);
//                educacion.setAnio_fin(anio_fin);
//
//                Long idImagenIdentidad = null;
//                if (educacion.getId() != null) { //compruebo si habia una imagen guardada
//                    idImagenIdentidad = educacion.getImagenIdentidad().getId(); //pido la id de esa imagen
//                }
//
//                ImagenIdentidad imagenIdentidad = imagenIdentidadServicio.actualizar(idImagenIdentidad, archivo1); //guarda la foto si no existia o la modifica
//                educacion.setImagenIdentidad(imagenIdentidad); //seteo con los cambios guardados
//
//                educacionRepositorio.save(educacion); //se guardan los cambios en la base de datos
//            } else {
//                throw new ErrorServicio("No tiene permisos suficientes para realizar la operacion");
//            }
//        } else {
//            throw new ErrorServicio("No existe un estudio con ese ID");
//        }
//
//    }
//
//    @Transactional(readOnly = true)
//    public List<Educacion> listarEducacion() {
//        return educacionRepositorio.findAll();
//    }
//
//    @Transactional(readOnly = true)
//    public Educacion buscarEducacionPorId(Long id) throws ErrorServicio {
//
//        Optional<Educacion> respuesta = educacionRepositorio.findById(id);
//
//        if (respuesta.isPresent()) {
//            Educacion educacion = respuesta.get();
//
//            return educacion;
//        } else {
//            throw new ErrorServicio("No se encontro ese estudio");
//        }
//    }
//
//    @Transactional
//    public void eliminarEducacion(Long idPersona, Long idEducacion) throws ErrorServicio {
//
//        Optional<Educacion> respuesta = educacionRepositorio.findById(idEducacion);
//        if (respuesta.isPresent()) {
//            Educacion educacion = respuesta.get();
//            if (educacion.getPersona().getId().equals(idPersona)) {
//                educacionRepositorio.deleteById(idEducacion);
//            } else {
//                throw new ErrorServicio("No tiene permisos suficientes para realizar la operacion");
//            }
//        } else {
//            throw new ErrorServicio("No existe un estudio con ese ID");
//        }
//    }
//
//    public void validaciones(String titulo, String institucion, Integer anio_inicio, Integer anio_fin) throws ErrorServicio {
//
//        if (titulo == null || titulo.trim().isEmpty()) {
//            throw new ErrorServicio("Título no puede estar vacío ni ser null");
//        }
//        if (institucion == null || institucion.trim().isEmpty()) {
//            throw new ErrorServicio("Nombre no puede estar vacío ni ser null");
//        }
//        if (anio_inicio == null || anio_inicio <= 0) {
//            throw new ErrorServicio("El año de inicio no puede ser nulo o menor a 0");
//        }
//        if (anio_fin == null || anio_fin <= 0) {
//            throw new ErrorServicio("El año de inicio no puede ser nulo o menor a 0");
//        }
//    }
