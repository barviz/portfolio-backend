package com.proyecto.PortfolioArgProg.repositorios;

import com.proyecto.PortfolioArgProg.entidades.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Barbara
 */
@Repository
public interface EducacionRepositorio extends JpaRepository<Educacion, Long> {
    
}
