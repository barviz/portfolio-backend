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
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id")
    private Long id;

    @Column(name = "persona_nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "persona_apellido", length = 45, nullable = false)
    private String apellido;

    @Column(name = "persona_titulo", length = 45, nullable = false)
    private String titulo;

    @Column(name = "persona_ubicacion", length = 45, nullable = false)
    private String ubicacion;
    
    @Column(name = "persona_descripcion", length = 1000, nullable = false)
    private String descripcion;
    
//    @Column(name = "persona_img_url_perfil", length = 200, nullable = false)
//    private String img_url_perfil;
    
//    @Column(name = "persona_img_url_banner", length = 200, nullable = false)
//    private String img_url_banner;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "imagen_identidad_id", nullable = false)
    private ImagenIdentidad imagenIdentidad;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "imagen_banner_id", nullable = false)
    private ImagenBanner imagenBanner;

    
    
}


























//@Column(name = "persona_img_perfil", length = 200, nullable = false)
//    private String imagenPerfil;
//    
