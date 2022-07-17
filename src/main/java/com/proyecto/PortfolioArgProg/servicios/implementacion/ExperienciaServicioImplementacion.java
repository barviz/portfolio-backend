package com.proyecto.PortfolioArgProg.servicios.implementacion;

import com.proyecto.PortfolioArgProg.dtos.ExperienciaDto;
import com.proyecto.PortfolioArgProg.entidades.Experiencia;
import com.proyecto.PortfolioArgProg.entidades.ImagenIdentidad;
import com.proyecto.PortfolioArgProg.repositorios.ExperienciaRepositorio;
import com.proyecto.PortfolioArgProg.repositorios.ImagenIdentidadRepositorio;
import com.proyecto.PortfolioArgProg.servicios.interfaces.ExperienciaServicioInterfaz;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Barbara
 */
@Service
public class ExperienciaServicioImplementacion implements ExperienciaServicioInterfaz {
    
    @Autowired
    public ExperienciaRepositorio experienciaRepositorio;

    @Autowired
    public ImagenIdentidadRepositorio imagenIdentidadRepositorio;

    @Override
    public Experiencia crearExperiencia(ExperienciaDto dto) {

        Experiencia experiencia = new Experiencia();

        experiencia.setPuesto(dto.getPuesto());
        experiencia.setEmpresa(dto.getEmpresa());
        experiencia.setDescripcion(dto.getDescripcion());
        experiencia.setAnio_inicio(dto.getAnio_inicio());
        experiencia.setAnio_fin(dto.getAnio_fin());
//        experiencia.setImg_url(dto.getImg_url());

        Optional<ImagenIdentidad> imagenIdentidadOpt = imagenIdentidadRepositorio.findById(dto.getImagenIdentidad());
        if (imagenIdentidadOpt.isPresent()) {
            experiencia.setImagenIdentidad(imagenIdentidadOpt.get());
        }

        experienciaRepositorio.save(experiencia);

        return experiencia;
    }

    @Override
    public Experiencia actualizarExperiencia(ExperienciaDto dto) {

        Optional<Experiencia> experienciaOpt = experienciaRepositorio.findById(dto.getId());

        if (experienciaOpt.isPresent()) {

            Experiencia experiencia = experienciaOpt.get();

            experiencia.setPuesto((!dto.getPuesto().isEmpty()) ? dto.getPuesto() : experiencia.getPuesto());
            experiencia.setEmpresa((!dto.getEmpresa().isEmpty()) ? dto.getEmpresa() : experiencia.getEmpresa());
            experiencia.setDescripcion((!dto.getDescripcion().isEmpty()) ? dto.getDescripcion() : experiencia.getDescripcion());
            experiencia.setAnio_inicio((dto.getAnio_inicio()!=null) ? dto.getAnio_inicio() : experiencia.getAnio_inicio());
            experiencia.setAnio_fin((dto.getAnio_fin()!=null) ? dto.getAnio_fin() : experiencia.getAnio_fin());
//            experiencia.setImg_url((!dto.getImg_url().isEmpty()) ? dto.getImg_url() : experiencia.getImg_url());
            
            Optional<ImagenIdentidad> imagenIdentidadOpt = imagenIdentidadRepositorio.findById(dto.getImagenIdentidad());
            if (imagenIdentidadOpt.isPresent()) {
                experiencia.setImagenIdentidad((dto.getImagenIdentidad()!=null)?imagenIdentidadOpt.get():experiencia.getImagenIdentidad());
            }

                experienciaRepositorio.save(experiencia);

                return experiencia;
            }
            
        return null;
    }

    @Override
    public void eliminarExperiencia(Long id) {
        Optional<Experiencia> experienciaOpt = experienciaRepositorio.findById(id);
        if (experienciaOpt.isPresent()) {
            experienciaRepositorio.delete(experienciaOpt.get());
        }
    }

    @Override
    public List<Experiencia> listarExperiencia() {
        List<Experiencia> experiencia = experienciaRepositorio.findAll();
        return experiencia;
    }

    @Override
    public Experiencia buscarExperienciaPorId(Long id) {
        Optional<Experiencia> experienciaOpt = experienciaRepositorio.findById(id);
        if (experienciaOpt.isPresent()) {
            return experienciaOpt.get();
        }
        return null;
    }


}




































//    @Autowired
//    private PersonaRepositorio personaRepositorio;
//
//    @Autowired
//    private ExperienciaRepositorio experienciaRepositorio; //persisto 
//
//    //vinculo los servicios de las imagenes con el servicio de usuario
//    @Autowired
//    private ImagenIdentidadServicioImplementacion imagenIdentidadServicio;
//
//    @Transactional
//    public void crearExperiencia(MultipartFile archivo1, Long idPersona, String puesto, String empresa, String descripcion, Integer anio_inicio, Integer anio_fin) throws ErrorServicio {
//
//        Persona persona = personaRepositorio.findById(idPersona).get();
//
//        validaciones(puesto, empresa, descripcion, anio_inicio, anio_fin);
//
//        Experiencia experiencia = new Experiencia(); //creo una experiencia y seteo atributos
//
//        experiencia.setPuesto(puesto);
//        experiencia.setEmpresa(empresa);
//        experiencia.setDescripcion(descripcion);
//        experiencia.setAnio_fin(anio_fin);
//        experiencia.setPersona(persona);
//
//        ImagenIdentidad imagenIdentidad = imagenIdentidadServicio.guardar(archivo1); //persisto una nueva imagen y la devuelvo en la variable
//        experiencia.setImagenIdentidad(imagenIdentidad);
//
//        experienciaRepositorio.save(experiencia);
//    }
//
//    @Transactional
//    public void modificarExperiencia(MultipartFile archivo1, Long idPersona, Long idExperiencia, String puesto, String empresa, String descripcion, Integer anio_inicio, Integer anio_fin) throws ErrorServicio { //recibo el id de la persona que quiere realizar los cambios
//
//        validaciones(puesto, empresa, descripcion, anio_inicio, anio_fin);
//
//        Optional<Experiencia> respuesta = experienciaRepositorio.findById(idExperiencia); //en la base de datos busca una experiencia que tenga ese id
//
//        if (respuesta.isPresent()) {
//            Experiencia experiencia = respuesta.get(); //trae los datos de experiencia con ese id
//
//            if (experiencia.getPersona().getId().equals(idExperiencia)) { //verifico que ese experiencia pertenezca a la persona
//                //si es así se permiten los cambios
//
//                experiencia.setPuesto(puesto);
//                experiencia.setEmpresa(empresa);
//                experiencia.setDescripcion(descripcion);
//                experiencia.setAnio_fin(anio_fin);
//
//                Long idImagenIdentidad = null;
//                if (experiencia.getId() != null) { //compruebo si habia una imagen guardada
//                    idImagenIdentidad = experiencia.getImagenIdentidad().getId(); //pido la id de esa imagen
//                }
//
//                ImagenIdentidad imagenIdentidad = imagenIdentidadServicio.actualizar(idImagenIdentidad, archivo1); //guarda la foto si no existia o la modifica
//                experiencia.setImagenIdentidad(imagenIdentidad); //seteo con los cambios guardados
//
//                experienciaRepositorio.save(experiencia); //se guardan los cambios en la base de datos
//            } else {
//                throw new ErrorServicio("No tiene permisos suficientes para realizar la operacion");
//            }
//        } else {
//            throw new ErrorServicio("No existe una experiencia con ese ID");
//        }
//
//    }
//
//    @Transactional(readOnly = true)
//    public List<Experiencia> listarEducacion() {
//        return experienciaRepositorio.findAll();
//    }
//
//    @Transactional(readOnly = true)
//    public Experiencia buscarEducacionPorId(Long id) throws ErrorServicio {
//
//        Optional<Experiencia> respuesta = experienciaRepositorio.findById(id);
//
//        if (respuesta.isPresent()) {
//            Experiencia experiencia = respuesta.get();
//
//            return experiencia;
//        } else {
//            throw new ErrorServicio("No se encontro esa experiencia");
//        }
//    }
//
//    @Transactional
//    public void eliminarExperiencia(Long idPersona, Long idExperiencia) throws ErrorServicio {
//
//        Optional<Experiencia> respuesta = experienciaRepositorio.findById(idExperiencia);
//        if (respuesta.isPresent()) {
//            Experiencia experiencia = respuesta.get();
//            if (experiencia.getPersona().getId().equals(idPersona)) {
//                experienciaRepositorio.deleteById(idExperiencia);
//            } else {
//                throw new ErrorServicio("No tiene permisos suficientes para realizar la operacion");
//            }
//        } else {
//            throw new ErrorServicio("No existe una experiencia con ese ID");
//        }
//    }
//
//    public void validaciones(String puesto, String empresa, String descripcion, Integer anio_inicio, Integer anio_fin) throws ErrorServicio {
//
//        if (puesto == null || puesto.trim().isEmpty()) {
//            throw new ErrorServicio("Puesto no puede estar vacío ni ser null");
//        }
//        if (empresa == null || empresa.trim().isEmpty()) {
//            throw new ErrorServicio("Nombre no puede estar vacío ni ser null");
//        }
//        if (descripcion == null || descripcion.trim().isEmpty()) {
//            throw new ErrorServicio("Descripcion no puede estar vacío ni ser null");
//        }
//        if (anio_inicio == null || anio_inicio <= 0) {
//            throw new ErrorServicio("El año de inicio no puede ser nulo o menor a 0");
//        }
//        if (anio_fin == null || anio_fin <= 0) {
//            throw new ErrorServicio("El año de inicio no puede ser nulo o menor a 0");
//        }
//    }
