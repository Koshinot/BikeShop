package com.example.BikeShop.service;

import com.example.BikeShop.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findById(String userId);
    User registerUser(User user);
}
