package com.proyecto.PortfolioArgProg.dtos;

import lombok.Data;

/**
 *
 * @author Barbara
 */
@Data
public class PersonaDto {
    
    private Long id;
    private String nombre;
    private String apellido;
    private String titulo;
    private String ubicacion;
    private String descripcion;
    private String img_url_perfil;
//    private String img_url_banner;
    private Long imagenIdentidad;
    private Long imagenBanner;
    
    
}
