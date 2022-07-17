package com.proyecto.PortfolioArgProg.servicios.interfaces;

import com.proyecto.PortfolioArgProg.dtos.ImagenBannerDto;
import com.proyecto.PortfolioArgProg.entidades.ImagenBanner;
import java.util.List;

/**
 *
 * @author Barbara
 */
public interface ImagenBannerServicioInterfaz {
    
    public ImagenBanner crearImagenBanner(ImagenBannerDto dto);
    public ImagenBanner actualizarImagenBanner(ImagenBannerDto dto);
    public void eliminarImagenBanner(Long id);
    public List<ImagenBanner> listarImagenBanner();
    public ImagenBanner buscarImagenBannerPorId(Long id);
    
    
}
