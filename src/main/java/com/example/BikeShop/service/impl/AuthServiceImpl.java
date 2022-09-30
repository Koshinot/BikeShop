package com.example.BikeShop.service.impl;

import com.example.BikeShop.model.Roles;
import com.example.BikeShop.model.User;
import com.example.BikeShop.model.exception.PasswordDoesntMatchException;
import com.example.BikeShop.persistance.RolesRepository;
import com.example.BikeShop.persistance.UserRepository;
import com.example.BikeShop.service.AuthService;
import com.example.BikeShop.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RolesRepository rolesRepository;
    private final UserService userService;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RolesRepository rolesRepository, UserService userService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.rolesRepository = rolesRepository;
        this.userService = userService;
    }

    @Override
    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    }

    @Override
    public String getCurrentUserId() {
        return this.getCurrentUser().getUsername();
    }

    @Override
    public User signUpUser(String username,
                           String password,
                           String repeatedPassword) {
        if (!password.equals(repeatedPassword)) {
            throw new PasswordDoesntMatchException();
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        Roles userRoles = this.rolesRepository.findByName("ROLE_USER");
        user.setRoles(Collections.singletonList(userRoles));
        return this.userService.registerUser(user);
    }


    @PostConstruct
    public void init() {
        if (!this.userRepository.existsById("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(this.passwordEncoder.encode("admin"));
            admin.setRoles(this.rolesRepository.findAll());
            this.userRepository.save(admin);
        }
    }
}
