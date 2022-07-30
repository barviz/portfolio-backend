package com.proyecto.PortfolioArgProg.servicios.implementacion;

import com.proyecto.PortfolioArgProg.dtos.HabilidadDto;
import com.proyecto.PortfolioArgProg.entidades.Habilidad;
import com.proyecto.PortfolioArgProg.repositorios.HabilidadRepositorio;
import com.proyecto.PortfolioArgProg.servicios.interfaces.HabilidadServicioInterfaz;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Barbara
 */
@Service
public class HabilidadServicioImplementacion implements HabilidadServicioInterfaz {

    @Autowired
    public HabilidadRepositorio habilidadRepositorio;

    @Override
    public Habilidad crearHabilidad(HabilidadDto dto) {

        Habilidad habilidad = new Habilidad();

        habilidad.setNombre(dto.getNombre());
        habilidad.setPorcentaje(dto.getPorcentaje());
        habilidad.setImg_url_logo(dto.getImg_url_logo());

        habilidadRepositorio.save(habilidad);

        return habilidad;
    }

    @Override
    public Habilidad actualizarHabilidad(HabilidadDto dto) {

        Optional<Habilidad> habilidadOpt = habilidadRepositorio.findById(dto.getId());

        if (habilidadOpt.isPresent()) {

            Habilidad habilidad = habilidadOpt.get();

            habilidad.setNombre((!dto.getNombre().isEmpty()) ? dto.getNombre() : habilidad.getNombre());
            habilidad.setPorcentaje((dto.getPorcentaje() != null) ? dto.getPorcentaje() : habilidad.getPorcentaje());
            habilidad.setImg_url_logo((!dto.getImg_url_logo().isEmpty()) ? dto.getImg_url_logo() : habilidad.getImg_url_logo());

            habilidadRepositorio.save(habilidad);

            return habilidad;
        }

        return null;
    }

    @Override
    public void eliminarHabilidad(Long id) {
        Optional<Habilidad> habilidadOpt = habilidadRepositorio.findById(id);
        if (habilidadOpt.isPresent()) {
            habilidadRepositorio.delete(habilidadOpt.get());
        }
    }

    @Override
    public List<Habilidad> listarHabilidad() {
        List<Habilidad> habilidad = habilidadRepositorio.findAll();
        return habilidad;
    }

    @Override
    public Habilidad buscarHabilidadPorId(Long id) {
        Optional<Habilidad> habilidadOpt = habilidadRepositorio.findById(id);
        if (habilidadOpt.isPresent()) {
            return habilidadOpt.get();
        }
        return null;
    }

}
