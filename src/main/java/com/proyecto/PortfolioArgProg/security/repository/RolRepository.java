package com.proyecto.PortfolioArgProg.security.repository;

import com.proyecto.PortfolioArgProg.security.entity.Rol;
import com.proyecto.PortfolioArgProg.security.enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Barbara
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    
    Optional<Rol> findByRolName(RolName rolName);
    
}
