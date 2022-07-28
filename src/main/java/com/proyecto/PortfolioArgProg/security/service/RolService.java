package com.proyecto.PortfolioArgProg.security.service;

import com.proyecto.PortfolioArgProg.security.repository.RolRepository;
import com.proyecto.PortfolioArgProg.security.entity.Rol;
import com.proyecto.PortfolioArgProg.security.enums.RolName;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Barbara
 */
@Service
@Transactional
public class RolService {
    
    @Autowired RolRepository rolRepository;
    
    public Optional<Rol> getByRolName(RolName rolName){
        return rolRepository.findByRolName(rolName);
    }
    
    public void save(Rol rol){
        rolRepository.save(rol);
    }
    
}
