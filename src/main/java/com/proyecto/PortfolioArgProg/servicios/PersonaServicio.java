/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.PortfolioArgProg.servicios;

import com.proyecto.PortfolioArgProg.entidades.Persona;
import com.proyecto.PortfolioArgProg.errores.ErrorServicio;
import com.proyecto.PortfolioArgProg.repositorios.PersonaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Barbara
 */

@Service
public class PersonaServicio {
 
    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Transactional
    public Persona crearPersona(String nombre, String apellido, String titulo, String ubicacion) throws Exception {

        validaciones(nombre, apellido, titulo, ubicacion);

        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setTitulo(titulo);
        persona.setUbicacion(ubicacion);

        return personaRepositorio.save(persona);
    }

    @Transactional
    public Persona modificarPersona(String id, String nombre, String apellido, String titulo, String ubicacion) throws Exception {

        validaciones(nombre, apellido, titulo, ubicacion);
        
        Optional<Persona> personaOpt = personaRepositorio.findById(id);

        if (personaOpt.isPresent()) {
            Persona persona = personaOpt.get();

            persona.setNombre(nombre);

            return personaRepositorio.save(persona);
        } else {
            throw new Exception("No existe una persona con ese ID");
        }

    }

    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return personaRepositorio.findAll();
    }

    @Transactional(readOnly = true)
    public Persona listarPersonasPorId(String id) throws ErrorServicio {

        Optional<Persona> clienteOp = personaRepositorio.findById(id);

        if (clienteOp.isPresent()) {
            Persona cliente = clienteOp.get();

            return cliente;
        } else {
            throw new ErrorServicio("No se encontro el cliente");
        }
    }
    
    @Transactional
    public void eliminarPersona(String id) throws ErrorServicio{
     Optional <Persona> personaOp = personaRepositorio.findById(id);
        if (personaOp.isPresent()) {
            personaRepositorio.deleteById(id);
        }else {
            throw new ErrorServicio("No se encontro la persona");
        }
    }

    
    public void validaciones(String nombre, String apellido, String titulo, String ubicacion) throws Exception {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Nombre no puede estar vacío no ser null");
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new Exception("Apellido no puede estar vacío no ser null");
        }
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new Exception("Título no puede estar vacío no ser null");
        }
        if (ubicacion == null || ubicacion.trim().isEmpty()) {
            throw new Exception("Ubicación no puede estar vacío no ser null");
        }
    }

    
}
