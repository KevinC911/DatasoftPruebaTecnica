package com.datasoftlibrary.controllers;

import com.datasoftlibrary.models.DTOs.CreateUserDTO;
import com.datasoftlibrary.models.DTOs.UserDTO;
import com.datasoftlibrary.models.User;
import com.datasoftlibrary.repositories.UserRepository;
import com.datasoftlibrary.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder encoder, JwtUtil jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody CreateUserDTO userInfo) {

        User userFound = userRepository.findByUsername(userInfo.getUsername());

        if (userFound == null){
            return ResponseEntity.badRequest().body("Username not found");
        }

        if (!encoder.matches(userInfo.getPasswd(), userFound.getPasswd())) {
            return ResponseEntity.badRequest().body("Incorrect password");
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userInfo.getUsername(),
                        userInfo.getPasswd()
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(jwtUtils.generateToken(userDetails.getUsername()));

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserDTO userInfo) {
        if (userRepository.findByUsername(userInfo.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        // Create new user's account
        User newUser = User.builder()
                        .id(userInfo.getId())
                        .full_name(userInfo.getFull_name())
                        .username(userInfo.getUsername())
                        .passwd(encoder.encode(userInfo.getPasswd()))
                        .state(userInfo.getState()).build();

        userRepository.save(newUser);
        return ResponseEntity.ok("User registered successfully");

    }
}
