package com.cognizant.employeemanagementsystem.controller;

import com.cognizant.employeemanagementsystem.model.AuthenticationResponse;
import com.cognizant.employeemanagementsystem.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {

        String encoded = authorizationHeader.substring(6);

        byte[] decodedBytes = Base64.getDecoder().decode(encoded);

        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);

        String username = credentials.split(":")[0];

        String token = jwtUtil.generateToken(username);

        return new AuthenticationResponse(token);

    }

}