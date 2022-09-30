package com.example.BikeShop.web.controller;

import com.example.BikeShop.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    private final AuthService authService;

    public SignUpController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getSignUpPage() {
        return "signup";
    }

    @PostMapping
    public String signUpUser(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String repeatedPassword) {
        try {
            this.authService.signUpUser(username,password,repeatedPassword);
            return "redirect:/login?info=SuccessfulRegistration!";
        } catch (RuntimeException ex) {
            return "redirect:/signup?error=" + ex.getLocalizedMessage();
        }
    }
}
