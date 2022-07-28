package com.proyecto.PortfolioArgProg.security.entity;

import com.proyecto.PortfolioArgProg.security.enums.RolName;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author Barbara
 */
@Data
@Entity
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "rol_rolname", nullable = false)
    private RolName rolName;

    public Rol() {
    }

    public Rol(RolName rolName) {
        this.rolName = rolName;
    }
    
    
    
}
