package com.example.oauth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.oauth.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/token")
    public ResponseEntity<String> generateToken(@RequestParam String username) {
        System.out.println("Requête reçue pour username: " + username); 
        String token = jwtService.generateToken(username);
        System.out.println("✅ Token généré: " + token);
        return ResponseEntity.ok(token);
    }
}
