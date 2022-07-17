package com.proyecto.PortfolioArgProg.dtos;

import lombok.Data;

/**
 *
 * @author Barbara
 */
@Data
public class EducacionDto {

    private Long id;
    private String titulo;
    private String institucion;
    private Integer anio_inicio;
    private Integer anio_fin;
//    private String img_url;
    private Long imagenIdentidad;
}
