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
@Table(name = "tecnologia")
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tecnologia_id")
    private Long id;

    @Column(name = "tecnologia_nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "tecnologia_porcentaje")
    private String porcentaje;

    @Column(name = "tecnologia_img_url_logo", length = 200, nullable = false)
    private String img_url_logo;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "imagen_identidad_id", nullable = true)
//    private ImagenIdentidad imagenIdentidad;
    
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "persona_id", nullable = true)
//    private Persona persona;
}
