package com.proyecto.PortfolioArgProg.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Barbara
 */
@RestController
@CrossOrigin(origins = "https://portfolio-blv.web.app")
public class PortalControlador {

    @GetMapping("/")
    ResponseEntity<String> decirHola() {
        return new ResponseEntity<>("holaaaaa!!!", HttpStatus.OK);
    }

    
    
}
