package com.approval.workflow.controller;

import com.approval.workflow.helper.JwtUtil;
import com.approval.workflow.model.JwtRequest;
import com.approval.workflow.model.JwtResponse;
import com.approval.workflow.service.jwtservice.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) {
        System.out.println(jwtRequest);
        try {
            this.authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        } catch (BadCredentialsException authenticate) {
            System.out.println(authenticate.getMessage());
        }
        //System.out.println(authenticate);
        UserDetails userDetails = this.customUserDetailService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println(token);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
