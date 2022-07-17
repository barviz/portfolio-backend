package com.proyecto.PortfolioArgProg.servicios.interfaces;

import com.proyecto.PortfolioArgProg.dtos.ExperienciaDto;
import com.proyecto.PortfolioArgProg.entidades.Experiencia;
import java.util.List;

/**
 *
 * @author Barbara
 */
public interface ExperienciaServicioInterfaz {
    
    public Experiencia crearExperiencia(ExperienciaDto dto);
    public Experiencia actualizarExperiencia(ExperienciaDto dto);
    public void eliminarExperiencia(Long id);
    public List<Experiencia> listarExperiencia();
    public Experiencia buscarExperienciaPorId(Long id);
    
}
