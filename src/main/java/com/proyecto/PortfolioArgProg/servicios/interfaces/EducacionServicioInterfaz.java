package com.proyecto.PortfolioArgProg.servicios.interfaces;

import com.proyecto.PortfolioArgProg.dtos.EducacionDto;
import com.proyecto.PortfolioArgProg.entidades.Educacion;
import java.util.List;

/**
 *
 * @author Barbara
 */
public interface EducacionServicioInterfaz {
    
    public Educacion crearEducacion(EducacionDto dto);
    public Educacion actualizarEducacion(EducacionDto dto);
    public void eliminarEducacion(Long id);
    public List<Educacion> listarEducacion();
    public Educacion buscarEducacionPorId(Long id);
    
}
