package com.proyecto.PortfolioArgProg.security.controller;

import lombok.Data;

/**
 *
 * @author Barbara
 */
@Data
public class Message {
    
    private String mensaje;

    public Message() {
    }

    public Message(String mensaje) {
        this.mensaje = mensaje;
    }
}
