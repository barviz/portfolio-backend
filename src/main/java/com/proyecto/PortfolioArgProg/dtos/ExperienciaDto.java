package com.proyecto.PortfolioArgProg.dtos;

import lombok.Data;

/**
 *
 * @author Barbara
 */
@Data
public class ExperienciaDto {

    private Long id;
    private String puesto;
    private String empresa;
    private String descripcion;
    private Integer anio_inicio;
    private Integer anio_fin;
    private String img_url_logo;
//    private Long imagenIdentidad;
}
