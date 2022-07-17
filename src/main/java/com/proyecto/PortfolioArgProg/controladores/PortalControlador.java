package com.proyecto.PortfolioArgProg.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Barbara
 */
@RestController
public class PortalControlador {

    @GetMapping("/")
    ResponseEntity<String> decirHola() {
        return new ResponseEntity<>("holaaaaa!!!", HttpStatus.OK);
    }

    
    
}
