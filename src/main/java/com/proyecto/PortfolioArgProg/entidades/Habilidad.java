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
@Table(name = "habilidad")
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habilidad_id")
    private Long id;

    @Column(name = "habilidad_nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "habilidad_porcentaje")
    private Integer porcentaje;

    @Column(name = "habilidad_img_url_logo", length = 200, nullable = false)
    private String img_url_logo;

}
