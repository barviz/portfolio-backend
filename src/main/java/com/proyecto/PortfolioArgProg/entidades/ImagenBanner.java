package com.proyecto.PortfolioArgProg.entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Barbara
 */
@Data
@Entity
@Table(name = "imagen_banner")
public class ImagenBanner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imagen_banner_id")
    private Long id;

    @Column(name = "imagen_banner_mime", length = 200)
    private String mime;
    /*asigna el tipo de formato del archivo de la foto*/
    @Column(name = "imagen_banner_nombre", length = 200)
    private String nombre;

    @Lob
    /*identifica que el tipo de dato es pesado*/
    @Basic(fetch = FetchType.EAGER)
    /*indica que cargue el contenido solo cuando lo pidamos haciendo que los queries sean mas livianos. cuando se consulte por la foto solo va a traer los atributos marcados como viber y mediante un metodo get se traera los atributos lazy*/
    @Column(name = "imagen_banner_contenido")
    private byte[] contenido;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "persona_id", nullable = false)
//    @JsonIgnore
//    private Persona persona;

}
