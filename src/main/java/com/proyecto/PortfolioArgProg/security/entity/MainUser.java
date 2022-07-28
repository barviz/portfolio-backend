package com.proyecto.PortfolioArgProg.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Barbara
 */
@Data
public class MainUser implements UserDetails {

    private String userName;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public MainUser(String userName, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static MainUser build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolName().name())).collect(Collectors
                .toList());
        return new MainUser(user.getUserName(), user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public String getUsername() {
        return userName;
    }
    
    public String getEmail() {
        return email;
    }
    
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
