package com.proyecto.PortfolioArgProg.servicios.implementacion;

import com.proyecto.PortfolioArgProg.dtos.PersonaResumenDto;
import com.proyecto.PortfolioArgProg.entidades.PersonaResumen;
import com.proyecto.PortfolioArgProg.repositorios.PersonaResumenRepositorio;
import com.proyecto.PortfolioArgProg.servicios.interfaces.PersonaResumenServicioInterfaz;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Barbara
 */
@Service
public class PersonaResumenServicioImplementacion implements PersonaResumenServicioInterfaz{
    
    @Autowired
    public PersonaResumenRepositorio personaResumenRepositorio;

    @Override
    public PersonaResumen crearPersonaResumen(PersonaResumenDto dto) {

        PersonaResumen personaResumen = new PersonaResumen();

        personaResumen.setDescripcion(dto.getDescripcion());

        personaResumenRepositorio.save(personaResumen);

        return personaResumen;
    }

    @Override
    public PersonaResumen actualizarPersonaResumen(PersonaResumenDto dto) {

        Optional<PersonaResumen> personaResumenOpt = personaResumenRepositorio.findById(dto.getId());

        if (personaResumenOpt.isPresent()) {

            PersonaResumen personaResumen = personaResumenOpt.get();

            personaResumen.setDescripcion((!dto.getDescripcion().isEmpty()) ? dto.getDescripcion() : personaResumen.getDescripcion());
            
            personaResumenRepositorio.save(personaResumen);

                return personaResumen;
            }
            
        return null;
    }

    @Override
    public void eliminarPersonaResumen(Long id) {
        Optional<PersonaResumen> personaOpt = personaResumenRepositorio.findById(id);
        if (personaOpt.isPresent()) {
            personaResumenRepositorio.delete(personaOpt.get());
        }
    }

    @Override
    public List<PersonaResumen> listarPersonaResumen() {
        List<PersonaResumen> personaResumen = personaResumenRepositorio.findAll();
        return personaResumen;
    }

    @Override
    public PersonaResumen buscarPersonaResumenPorId(Long id) {
        Optional<PersonaResumen> personaResumenOpt = personaResumenRepositorio.findById(id);
        if (personaResumenOpt.isPresent()) {
            return personaResumenOpt.get();
        }
        return null;
    }

    
}
