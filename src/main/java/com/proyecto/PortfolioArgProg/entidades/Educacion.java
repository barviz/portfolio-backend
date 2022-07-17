package com.proyecto.PortfolioArgProg.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Barbara
 */
@Data
@Entity
@Table(name = "educacion")
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "educacion_id")
    private Long id;

    @Column(name = "educacion_titulo", length = 45, nullable = false)
    private String titulo;
    
    @Column(name = "educacion_institucion", length = 45, nullable = false)
    private String institucion;
    
    @Column(name = "educacion_anio_inicio")
    private Integer anio_inicio;
    
    @Column(name = "educacion_anio_fin")
    private Integer anio_fin;
    
//    @Column(name = "educacion_img_url", length = 200, nullable = false)
//    private String img_url;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "imagen_identidad_id", nullable = true)
    private ImagenIdentidad imagenIdentidad;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "persona_id", nullable = true)
//    private Persona persona;

    
}
