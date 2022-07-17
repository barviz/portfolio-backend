package com.proyecto.PortfolioArgProg.servicios.interfaces;

import com.proyecto.PortfolioArgProg.dtos.ImagenIdentidadDto;
import com.proyecto.PortfolioArgProg.entidades.ImagenIdentidad;
import java.util.List;

/**
 *
 * @author Barbara
 */
public interface ImagenIdentidadServicioInterfaz {
    
    public ImagenIdentidad crearImagenIdentidad(ImagenIdentidadDto dto);
    public ImagenIdentidad actualizarImagenIdentidad(ImagenIdentidadDto dto);
    public void eliminarImagenIdentidad(Long id);
    public List<ImagenIdentidad> listarImagenIdentidad();
    public ImagenIdentidad buscarImagenIdentidadPorId(Long id);
    
}
