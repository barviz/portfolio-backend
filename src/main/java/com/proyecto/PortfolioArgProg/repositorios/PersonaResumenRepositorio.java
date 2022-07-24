package com.proyecto.PortfolioArgProg.repositorios;

import com.proyecto.PortfolioArgProg.entidades.PersonaResumen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Barbara
 */
@Repository
public interface PersonaResumenRepositorio extends JpaRepository<PersonaResumen, Long>{
    
}
