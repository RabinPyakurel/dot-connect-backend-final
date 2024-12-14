package com.codefestnepal.dotconnect.controllers;

import com.codefestnepal.dotconnect.configuration.TokenService;
import com.codefestnepal.dotconnect.dtos.AgencyLoginDto;
import com.codefestnepal.dotconnect.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agency-login")
public class AgencyLoginController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseResult<String> login(@RequestBody AgencyLoginDto user) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        String token = tokenService.generateToken(auth);
        return ResponseResult.SuccessResult(token);
    }
}

