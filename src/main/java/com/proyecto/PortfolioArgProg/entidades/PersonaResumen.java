package com.proyecto.PortfolioArgProg.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Barbara
 */
@Data
@Entity
@Table(name = "persona_resumen")
public class PersonaResumen {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_resumen_id")
    private Long id;

    @Column(name = "persona_resumen_descripcion", length = 2000, nullable = false)
    private String descripcion;
    
}
