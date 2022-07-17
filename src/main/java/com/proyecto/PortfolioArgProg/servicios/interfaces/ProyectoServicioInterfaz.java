package com.proyecto.PortfolioArgProg.servicios.interfaces;

import com.proyecto.PortfolioArgProg.dtos.ProyectoDto;
import com.proyecto.PortfolioArgProg.entidades.Proyecto;
import java.util.List;

/**
 *
 * @author Barbara
 */
public interface ProyectoServicioInterfaz {
    
    public Proyecto crearProyecto(ProyectoDto dto);
    public Proyecto actualizarProyecto(ProyectoDto dto);
    public void eliminarProyecto(Long id);
    public List<Proyecto> listarProyecto();
    public Proyecto buscarProyectoPorId(Long id);
    
}
