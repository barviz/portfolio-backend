package com.proyecto.PortfolioArgProg.repositorios;

import com.proyecto.PortfolioArgProg.entidades.PersonaDatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Barbara
 */
@Repository
public interface PersonaDatosRepositorio extends JpaRepository<PersonaDatos, Long> {
    
}
