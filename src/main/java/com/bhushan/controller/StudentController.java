package com.bhushan.controller;

import com.bhushan.Response.AuthenticateResponse;
import com.bhushan.Response.StudentResponse;
import com.bhushan.dto.AuthRequestModel;
import com.bhushan.entity.UserInformation;
import com.bhushan.service.JwtService;
import com.bhushan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/addNewRecord")
    public StudentResponse addNewUser(@RequestBody UserInformation userInfo) {
        return service.addUser(userInfo);
    }

    @PostMapping("/authenticate")
    public AuthenticateResponse authenticateAndGetToken(@RequestBody AuthRequestModel authRequest) {
        AuthenticateResponse authenticateResponse = new AuthenticateResponse();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            authenticateResponse.setStatusCode("200");
            authenticateResponse.setMessage("JWT Token Generated");
            authenticateResponse.setJwtToken(jwtService.generateToken(authRequest.getUsername()));
        } else {
            authenticateResponse.setStatusCode("500");
            authenticateResponse.setMessage("Something Went Wrong , JWT Token Not Generated");
        }
        return authenticateResponse;
    }
}
