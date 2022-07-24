package com.proyecto.PortfolioArgProg.servicios.interfaces;

import com.proyecto.PortfolioArgProg.dtos.PersonaDatosDto;
import com.proyecto.PortfolioArgProg.entidades.PersonaDatos;
import java.util.List;

/**
 *
 * @author Barbara
 */
public interface PersonaDatosServicioInterfaz {
    
    public PersonaDatos crearPersonaDatos(PersonaDatosDto dto);
    public PersonaDatos actualizarPersonaDatos(PersonaDatosDto dto);
    public void eliminarPersonaDatos(Long id);
    public List<PersonaDatos> listarPersonaDatos();
    public PersonaDatos buscarPersonaDatosPorId(Long id);
    
}
