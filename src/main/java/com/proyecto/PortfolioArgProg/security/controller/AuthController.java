package com.proyecto.PortfolioArgProg.security.controller;


import com.proyecto.PortfolioArgProg.security.dto.JwtDto;
import com.proyecto.PortfolioArgProg.security.dto.NewUser;
import com.proyecto.PortfolioArgProg.security.dto.UserLogin;
import com.proyecto.PortfolioArgProg.security.entity.Rol;
import com.proyecto.PortfolioArgProg.security.entity.User;
import com.proyecto.PortfolioArgProg.security.enums.RolName;
import com.proyecto.PortfolioArgProg.security.jwt.JwtProvider;
import com.proyecto.PortfolioArgProg.security.service.RolService;
import com.proyecto.PortfolioArgProg.security.service.UserService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Barbara
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired PasswordEncoder passwordEncoder;
    
    @Autowired AuthenticationManager authenticationManager;
    
    @Autowired UserService userService;
    
    @Autowired RolService rolService;
    
    @Autowired JwtProvider jwtProvider;

    @PostMapping("/new-user")
    public ResponseEntity<?> newUser(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        }

        if (userService.existsByUserName(newUser.getUserName())) {
            return new ResponseEntity(new Message("Nombre de usuario ingresado existente"), HttpStatus.BAD_REQUEST);
        }

        if (userService.existsByEmail(newUser.getEmail())) {
            return new ResponseEntity(new Message("Mail ingresado existente"), HttpStatus.BAD_REQUEST);
        }

        User user = new User(newUser.getUserName(), newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolName.ROLE_USER).get());

        if (newUser.getRoles().contains("admin")) {
            roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
        }
        user.setRoles(roles);
        userService.save(user);

        return new ResponseEntity(new Message("Usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody UserLogin userLogin, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUserName(), userLogin.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

}
