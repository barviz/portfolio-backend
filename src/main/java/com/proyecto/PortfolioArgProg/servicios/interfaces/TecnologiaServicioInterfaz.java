package com.proyecto.PortfolioArgProg.servicios.interfaces;

import com.proyecto.PortfolioArgProg.dtos.TecnologiaDto;
import com.proyecto.PortfolioArgProg.entidades.Tecnologia;
import java.util.List;

/**
 *
 * @author Barbara
 */
public interface TecnologiaServicioInterfaz {
    
    public Tecnologia crearTecnologia(TecnologiaDto dto);
    public Tecnologia actualizarTecnologia(TecnologiaDto dto);
    public void eliminarTecnologia(Long id);
    public List<Tecnologia> listarTecnologia();
    public Tecnologia buscarTecnologiaPorId(Long id);
    
}
