package com.proyecto.PortfolioArgProg.servicios.interfaces;

import com.proyecto.PortfolioArgProg.dtos.PersonaDto;
import com.proyecto.PortfolioArgProg.entidades.Persona;
import java.util.List;

/**
 *
 * @author Barbara
 */
public interface PersonaServicioInterfaz {
    
    public Persona crearPersona(PersonaDto dto);
    public Persona actualizarPersona(PersonaDto dto);
    public void eliminarPersona(Long id);
    public List<Persona> listarPersonas();
    public Persona buscarPersonaPorId(Long id);
    
}
