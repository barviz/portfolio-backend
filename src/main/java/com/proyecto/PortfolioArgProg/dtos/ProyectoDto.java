package com.proyecto.PortfolioArgProg.dtos;

import lombok.Data;

/**
 *
 * @author Barbara
 */
@Data
public class ProyectoDto {

    private Long id;
    private String nombre;
    private String descripcion;
    private String link;
    private Integer anio;
    private String img_url_logo;
//    private Long imagenIdentidad;

}
