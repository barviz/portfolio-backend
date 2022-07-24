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
@Table(name = "experiencia_laboral")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experiencia_laboral_id")
    private Long id;

    @Column(name = "experiencia_laboral_puesto", length = 45, nullable = false)
    private String puesto;

    @Column(name = "experiencia_laboral_empresa", length = 45, nullable = false)
    private String empresa;
    
    @Column(name = "experiencia_laboral_descripcion", length = 300, nullable = false)
    private String descripcion;

    @Column(name = "experiencia_laboral_anio_inicio")
    private Integer anio_inicio;
    
    @Column(name = "experiencia_laboral_inicio")
    private Integer anio_fin;
    
    @Column(name = "experiencia_img_url_logo", length = 200, nullable = false)
    private String img_url_logo;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "imagen_identidad_id", nullable = true)
//    private ImagenIdentidad imagenIdentidad;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "persona_id", nullable = true)
//    private Persona persona;

    
}
