package com.proyecto.PortfolioArgProg.servicios.implementacion;

import com.proyecto.PortfolioArgProg.dtos.TecnologiaDto;
import com.proyecto.PortfolioArgProg.entidades.ImagenIdentidad;
import com.proyecto.PortfolioArgProg.entidades.Tecnologia;
import com.proyecto.PortfolioArgProg.repositorios.ImagenIdentidadRepositorio;
import com.proyecto.PortfolioArgProg.repositorios.TecnologiaRepositorio;
import com.proyecto.PortfolioArgProg.servicios.interfaces.TecnologiaServicioInterfaz;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Barbara
 */
@Service
public class TecnologiaServicioImplementacion implements TecnologiaServicioInterfaz {
    
    @Autowired
    public TecnologiaRepositorio tecnologiaRepositorio;

    @Autowired
    public ImagenIdentidadRepositorio imagenIdentidadRepositorio;

    @Override
    public Tecnologia crearTecnologia(TecnologiaDto dto) {

        Tecnologia tecnologia = new Tecnologia();

        tecnologia.setNombre(dto.getNombre());
        tecnologia.setPorcentaje(dto.getPorcentaje());
//        tecnologia.setImg_url(dto.getImg_url());

        Optional<ImagenIdentidad> imagenIdentidadOpt = imagenIdentidadRepositorio.findById(dto.getImagenIdentidad());
        if (imagenIdentidadOpt.isPresent()) {
            tecnologia.setImagenIdentidad(imagenIdentidadOpt.get());
        }

        tecnologiaRepositorio.save(tecnologia);

        return tecnologia;
    }

    @Override
    public Tecnologia actualizarTecnologia(TecnologiaDto dto) {

        Optional<Tecnologia> tecnologiaOpt = tecnologiaRepositorio.findById(dto.getId());

        if (tecnologiaOpt.isPresent()) {

            Tecnologia tecnologia = tecnologiaOpt.get();

            tecnologia.setNombre((!dto.getNombre().isEmpty()) ? dto.getNombre() : tecnologia.getNombre());
            tecnologia.setPorcentaje((!dto.getPorcentaje().isEmpty()) ? dto.getPorcentaje(): tecnologia.getPorcentaje());
//            tecnologia.setImg_url((!dto.getImg_url().isEmpty()) ? dto.getImg_url() : tecnologia.getImg_url());
            
            Optional<ImagenIdentidad> imagenIdentidadOpt = imagenIdentidadRepositorio.findById(dto.getImagenIdentidad());
            if (imagenIdentidadOpt.isPresent()) {
                tecnologia.setImagenIdentidad((dto.getImagenIdentidad()!=null)?imagenIdentidadOpt.get():tecnologia.getImagenIdentidad());
            }

                tecnologiaRepositorio.save(tecnologia);

                return tecnologia;
            }
            
        return null;
    }

    @Override
    public void eliminarTecnologia(Long id) {
        Optional<Tecnologia> tecnologiaOpt = tecnologiaRepositorio.findById(id);
        if (tecnologiaOpt.isPresent()) {
            tecnologiaRepositorio.delete(tecnologiaOpt.get());
        }
    }

    @Override
    public List<Tecnologia> listarTecnologia() {
        List<Tecnologia> tecnologia = tecnologiaRepositorio.findAll();
        return tecnologia;
    }

    @Override
    public Tecnologia buscarTecnologiaPorId(Long id) {
        Optional<Tecnologia> tecnologiaOpt = tecnologiaRepositorio.findById(id);
        if (tecnologiaOpt.isPresent()) {
            return tecnologiaOpt.get();
        }
        return null;
    }



}















































//    @Autowired
//    private PersonaRepositorio personaRepositorio;
//
//    @Autowired
//    private TecnologiaRepositorio tecnologiaRepositorio; //persisto 
//
//    //vinculo los servicios de las imagenes con el servicio de usuario
//    @Autowired
//    private ImagenIdentidadServicioImplementacion imagenIdentidadServicio;
//
//    @Transactional
//    public void crearTecnologia(MultipartFile archivo1, Long idPersona, String nombre, String porcentaje) throws ErrorServicio {
//
//        Persona persona = personaRepositorio.findById(idPersona).get();
//
//        validaciones(nombre, porcentaje);
//
//        Tecnologia tecnologia = new Tecnologia(); //creo una habilidad y seteo atributos
//
//        tecnologia.setNombre(nombre);
//        tecnologia.setPorcentaje(porcentaje);
//        tecnologia.setPersona(persona);
//
//        ImagenIdentidad imagenIdentidad = imagenIdentidadServicio.guardar(archivo1); //persisto una nueva imagen y la devuelvo en la variable
//        tecnologia.setImagenIdentidad(imagenIdentidad);
//
//        tecnologiaRepositorio.save(tecnologia);
//    }
//
//    @Transactional
//    public void modificarTecnologia(MultipartFile archivo1, Long idPersona, Long idTecnologia, String nombre, String porcentaje) throws ErrorServicio { //recibo el id de la persona que quiere realizar los cambios
//
//        validaciones(nombre, porcentaje);
//
//        Optional<Tecnologia> respuesta = tecnologiaRepositorio.findById(idTecnologia); //en la base de datos busca una habilidad que tenga ese id
//
//        if (respuesta.isPresent()) {
//            Tecnologia tecnologia = respuesta.get(); //trae los datos de habilidades con ese id
//
//            if (tecnologia.getPersona().getId().equals(idTecnologia)) { //verifico que esa habilidad pertenezca a la persona
//                //si es así se permiten los cambios
//
//                tecnologia.setNombre(nombre);
//                tecnologia.setPorcentaje(porcentaje);
//
//                Long idImagenIdentidad = null;
//                if (tecnologia.getId() != null) { //compruebo si habia una imagen guardada
//                    idImagenIdentidad = tecnologia.getImagenIdentidad().getId(); //pido la id de esa imagen
//                }
//
//                ImagenIdentidad imagenIdentidad = imagenIdentidadServicio.actualizar(idImagenIdentidad, archivo1); //guarda la foto si no existia o la modifica
//                tecnologia.setImagenIdentidad(imagenIdentidad); //seteo con los cambios guardados
//
//                tecnologiaRepositorio.save(tecnologia); //se guardan los cambios en la base de datos
//            } else {
//                throw new ErrorServicio("No tiene permisos suficientes para realizar la operacion");
//            }
//        } else {
//            throw new ErrorServicio("No existe una skill con ese ID");
//        }
//
//    }
//
//    @Transactional(readOnly = true)
//    public List<Tecnologia> listarTecnologia() {
//        return tecnologiaRepositorio.findAll();
//    }
//
//    @Transactional(readOnly = true)
//    public Tecnologia buscarTecnologiaPorId(Long id) throws ErrorServicio {
//
//        Optional<Tecnologia> respuesta = tecnologiaRepositorio.findById(id);
//
//        if (respuesta.isPresent()) {
//            Tecnologia tecnologia = respuesta.get();
//
//            return tecnologia;
//        } else {
//            throw new ErrorServicio("No se encontro esa skill");
//        }
//    }
//
//    @Transactional
//    public void eliminarTecnologia(Long idPersona, Long idTecnologia) throws ErrorServicio {
//
//        Optional<Tecnologia> respuesta = tecnologiaRepositorio.findById(idTecnologia);
//        if (respuesta.isPresent()) {
//            Tecnologia tecnologia = respuesta.get();
//            if (tecnologia.getPersona().getId().equals(idPersona)) {
//                tecnologiaRepositorio.deleteById(idTecnologia);
//            } else {
//                throw new ErrorServicio("No tiene permisos suficientes para realizar la operacion");
//            }
//        } else {
//            throw new ErrorServicio("No existe una skill con ese ID");
//        }
//    }
//
//    public void validaciones(String nombre, String porcentaje) throws ErrorServicio {
//
//        if (nombre == null || nombre.trim().isEmpty()) {
//            throw new ErrorServicio("nombre no puede estar vacío ni ser null");
//        }
//        if (porcentaje == null || porcentaje.trim().isEmpty()) {
//            throw new ErrorServicio("Porcentaje no puede estar vacío ni ser null");
//        }
//    }