package com.proyecto.PortfolioArgProg.repositorios;

import com.proyecto.PortfolioArgProg.entidades.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Barbara
 */
@Repository
public interface ExperienciaRepositorio extends JpaRepository<Experiencia, Long> {
    
}
