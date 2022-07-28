package com.proyecto.PortfolioArgProg.security.dto;

import java.util.Collection;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Barbara
 */
@Data
public class JwtDto {
    
    private String token;
    private String bearer = "Bearer";
    private String userName;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto() {
    }

    public JwtDto(String token, String userName, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.userName = userName;
        this.authorities = authorities;
    }
    
    
    
}
