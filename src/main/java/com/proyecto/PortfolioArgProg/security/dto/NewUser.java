package com.proyecto.PortfolioArgProg.security.dto;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author Barbara
 */
@Data
public class NewUser {
    
    private String userName;
    private String email;
    private String password;
    private Set<String> roles = new HashSet<>();

    public NewUser() {
    }

    public NewUser(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    
    
    
}
