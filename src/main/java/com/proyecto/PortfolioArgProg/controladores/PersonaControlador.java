/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.PortfolioArgProg.controladores;

import com.proyecto.PortfolioArgProg.entidades.Persona;
import com.proyecto.PortfolioArgProg.repositorios.PersonaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Barbara
 */

@Controller
public class PersonaControlador {
    
    @Autowired
    private PersonaRepositorio personaRepositorio;
    
    @GetMapping("/personas")
    public List<Persona> listarTodasLasPersonas(){
        return personaRepositorio.findAll();
    }
    
}
