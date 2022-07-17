package com.proyecto.PortfolioArgProg.repositorios;

import com.proyecto.PortfolioArgProg.entidades.ImagenBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Barbara
 */

@Repository
public interface ImagenBannerRepositorio extends JpaRepository<ImagenBanner, Long>{
    
}
