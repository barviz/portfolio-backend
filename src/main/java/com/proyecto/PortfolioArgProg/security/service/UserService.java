package com.proyecto.PortfolioArgProg.security.service;

import com.proyecto.PortfolioArgProg.security.repository.UserRepository;
import com.proyecto.PortfolioArgProg.security.entity.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Barbara
 */
@Service
public class UserService {
    
    @Autowired UserRepository userRepository;
    
    public Optional<User> getByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
    
    public boolean existsByUserName(String userName){
        return userRepository.existsByUserName(userName);
    }
    
    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
    
    public void save(User user){
        userRepository.save(user);
    }
    
}
