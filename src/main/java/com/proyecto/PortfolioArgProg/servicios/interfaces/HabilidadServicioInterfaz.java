package com.proyecto.PortfolioArgProg.servicios.interfaces;

import com.proyecto.PortfolioArgProg.dtos.HabilidadDto;
import com.proyecto.PortfolioArgProg.entidades.Habilidad;
import java.util.List;

/**
 *
 * @author Barbara
 */
public interface HabilidadServicioInterfaz {
    
    public Habilidad crearHabilidad(HabilidadDto dto);
    public Habilidad actualizarHabilidad(HabilidadDto dto);
    public void eliminarHabilidad(Long id);
    public List<Habilidad> listarHabilidad();
    public Habilidad buscarHabilidadPorId(Long id);
    
}
