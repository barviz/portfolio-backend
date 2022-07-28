package com.proyecto.PortfolioArgProg.security.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author Barbara
 */
@Data
public class UserLogin {
    
    @NotBlank
    private String userName;
    @NotBlank
    private String password;

    public UserLogin() {
    }

    public UserLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    
    
}
