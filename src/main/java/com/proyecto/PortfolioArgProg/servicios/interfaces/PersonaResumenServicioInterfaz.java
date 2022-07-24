package com.proyecto.PortfolioArgProg.servicios.interfaces;

import com.proyecto.PortfolioArgProg.dtos.PersonaResumenDto;
import com.proyecto.PortfolioArgProg.entidades.PersonaResumen;
import java.util.List;

/**
 *
 * @author Barbara
 */
public interface PersonaResumenServicioInterfaz {
    
    public PersonaResumen crearPersonaResumen(PersonaResumenDto dto);
    public PersonaResumen actualizarPersonaResumen(PersonaResumenDto dto);
    public void eliminarPersonaResumen(Long id);
    public List<PersonaResumen> listarPersonaResumen();
    public PersonaResumen buscarPersonaResumenPorId(Long id);
    
}
