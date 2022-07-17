package com.proyecto.PortfolioArgProg.servicios.implementacion;

import com.proyecto.PortfolioArgProg.dtos.ProyectoDto;
import com.proyecto.PortfolioArgProg.entidades.ImagenIdentidad;
import com.proyecto.PortfolioArgProg.entidades.Proyecto;
import com.proyecto.PortfolioArgProg.repositorios.ImagenIdentidadRepositorio;
import com.proyecto.PortfolioArgProg.repositorios.ProyectoRepositorio;
import com.proyecto.PortfolioArgProg.servicios.interfaces.ProyectoServicioInterfaz;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Barbara
 */
@Service
public class ProyectoServicioImplementacion implements ProyectoServicioInterfaz {

    @Autowired
    public ProyectoRepositorio proyectoRepositorio;

    @Autowired
    public ImagenIdentidadRepositorio imagenIdentidadRepositorio;

    @Override
    public Proyecto crearProyecto(ProyectoDto dto) {

        Proyecto proyecto = new Proyecto();

        proyecto.setNombre(dto.getNombre());
        proyecto.setDescripcion(dto.getDescripcion());
        proyecto.setLink(dto.getLink());
        proyecto.setAnio(dto.getAnio());
//        proyecto.setImg_url(dto.getImg_url());

        Optional<ImagenIdentidad> imagenIdentidadOpt = imagenIdentidadRepositorio.findById(dto.getImagenIdentidad());
        if (imagenIdentidadOpt.isPresent()) {
            proyecto.setImagenIdentidad(imagenIdentidadOpt.get());
        }

        proyectoRepositorio.save(proyecto);

        return proyecto;
    }

    @Override
    public Proyecto actualizarProyecto(ProyectoDto dto) {

        Optional<Proyecto> proyectoOpt = proyectoRepositorio.findById(dto.getId());

        if (proyectoOpt.isPresent()) {

            Proyecto proyecto = proyectoOpt.get();

            proyecto.setNombre((!dto.getNombre().isEmpty()) ? dto.getNombre() : proyecto.getNombre());
            proyecto.setDescripcion((!dto.getDescripcion().isEmpty()) ? dto.getDescripcion() : proyecto.getDescripcion());
            proyecto.setLink((!dto.getLink().isEmpty()) ? dto.getLink() : proyecto.getLink());
//            proyecto.setAnio((dto.getAnio() != null) ? dto.getAnio() : proyecto.getAnio());
//            proyecto.setImg_url((!dto.getImg_url().isEmpty()) ? dto.getImg_url() : proyecto.getImg_url());

            Optional<ImagenIdentidad> imagenIdentidadOpt = imagenIdentidadRepositorio.findById(dto.getImagenIdentidad());
            if (imagenIdentidadOpt.isPresent()) {
                proyecto.setImagenIdentidad((dto.getImagenIdentidad() != null) ? imagenIdentidadOpt.get() : proyecto.getImagenIdentidad());
            }

            proyectoRepositorio.save(proyecto);

            return proyecto;
        }

        return null;
    }

    @Override
    public void eliminarProyecto(Long id) {
        Optional<Proyecto> proyectoOpt = proyectoRepositorio.findById(id);
        if (proyectoOpt.isPresent()) {
            proyectoRepositorio.delete(proyectoOpt.get());
        }
    }

    @Override
    public List<Proyecto> listarProyecto() {
        List<Proyecto> proyecto = proyectoRepositorio.findAll();
        return proyecto;
    }

    @Override
    public Proyecto buscarProyectoPorId(Long id) {
        Optional<Proyecto> proyectoOpt = proyectoRepositorio.findById(id);
        if (proyectoOpt.isPresent()) {
            return proyectoOpt.get();
        }
        return null;
    }

}






































//    @Autowired
//    private PersonaRepositorio personaRepositorio;
//
//    @Autowired
//    private ProyectoRepositorio proyectoRepositorio; //persisto 
//
//    //vinculo los servicios de las imagenes con el servicio de usuario
//    @Autowired
//    private ImagenIdentidadServicioImplementacion imagenIdentidadServicio;
//
//    @Transactional
//    public void crearProyecto(MultipartFile archivo1, Long idPersona, String nombre, String descripcion, String link, Integer anio) throws ErrorServicio {
//
//        Persona persona = personaRepositorio.findById(idPersona).get();
//
//        validaciones(nombre, descripcion, link, anio);
//
//        Proyecto proyecto = new Proyecto(); //creo un proyecto y seteo atributos
//
//        proyecto.setNombre(nombre);
//        proyecto.setDescripcion(descripcion);
//        proyecto.setLink(link);
//        proyecto.setAnio(anio);
//        proyecto.setPersona(persona);
//
//        ImagenIdentidad imagenIdentidad = imagenIdentidadServicio.guardar(archivo1); //persisto una nueva imagen y la devuelvo en la variable
//        proyecto.setImagenIdentidad(imagenIdentidad);
//
//        proyectoRepositorio.save(proyecto);
//    }
//
//    @Transactional
//    public void modificarProyecto(MultipartFile archivo1, Long idPersona, Long idProyecto, String nombre, String descripcion, String link, Integer anio) throws ErrorServicio { //recibo el id de la persona que quiere realizar los cambios
//
//        validaciones(nombre, descripcion, link, anio);
//
//        Optional<Proyecto> respuesta = proyectoRepositorio.findById(idProyecto); //en la base de datos busca un proyecto que tenga ese id
//
//        if (respuesta.isPresent()) {
//            Proyecto proyecto = respuesta.get(); //trae los datos de proyecto con ese id
//
//            if (proyecto.getPersona().getId().equals(idProyecto)) { //verifico que ese experiencia pertenezca a la persona
//                //si es así se permiten los cambios
//
//                proyecto.setNombre(nombre);
//                proyecto.setDescripcion(descripcion);
//                proyecto.setLink(link);
//                proyecto.setAnio(anio);
//
//                Long idImagenIdentidad = null;
//                if (proyecto.getId() != null) { //compruebo si habia una imagen guardada
//                    idImagenIdentidad = proyecto.getImagenIdentidad().getId(); //pido la id de esa imagen
//                }
//
//                ImagenIdentidad imagenIdentidad = imagenIdentidadServicio.actualizar(idImagenIdentidad, archivo1); //guarda la foto si no existia o la modifica
//                proyecto.setImagenIdentidad(imagenIdentidad); //seteo con los cambios guardados
//
//                proyectoRepositorio.save(proyecto); //se guardan los cambios en la base de datos
//            } else {
//                throw new ErrorServicio("No tiene permisos suficientes para realizar la operacion");
//            }
//        } else {
//            throw new ErrorServicio("No existe un proyecto con ese ID");
//        }
//
//    }
//
//    @Transactional(readOnly = true)
//    public List<Proyecto> listarProyecto() {
//        return proyectoRepositorio.findAll();
//    }
//
//    @Transactional(readOnly = true)
//    public Proyecto buscarProyectoPorId(Long id) throws ErrorServicio {
//
//        Optional<Proyecto> respuesta = proyectoRepositorio.findById(id);
//
//        if (respuesta.isPresent()) {
//            Proyecto proyecto = respuesta.get();
//
//            return proyecto;
//        } else {
//            throw new ErrorServicio("No se encontro ese proyecto");
//        }
//    }
//
//    @Transactional
//    public void eliminarProyecto(Long idPersona, Long idProyecto) throws ErrorServicio {
//
//        Optional<Proyecto> respuesta = proyectoRepositorio.findById(idProyecto);
//        if (respuesta.isPresent()) {
//            Proyecto proyecto = respuesta.get();
//            if (proyecto.getPersona().getId().equals(idPersona)) {
//                proyectoRepositorio.deleteById(idProyecto);
//            } else {
//                throw new ErrorServicio("No tiene permisos suficientes para realizar la operacion");
//            }
//        } else {
//            throw new ErrorServicio("No existe un proyecto con ese ID");
//        }
//    }
//
//    public void validaciones(String nombre, String descripcion, String link, Integer anio) throws ErrorServicio {
//
//        if (nombre == null || nombre.trim().isEmpty()) {
//            throw new ErrorServicio("nombre no puede estar vacío ni ser null");
//        }
//        if (descripcion == null || descripcion.trim().isEmpty()) {
//            throw new ErrorServicio("Descripcion no puede estar vacío ni ser null");
//        }
//        if (link == null || link.trim().isEmpty()) {
//            throw new ErrorServicio("Link no puede estar vacío ni ser null");
//        }
//        if (anio == null || anio <= 0) {
//            throw new ErrorServicio("El año no puede ser nulo o menor a 0");
//        }
//    }
