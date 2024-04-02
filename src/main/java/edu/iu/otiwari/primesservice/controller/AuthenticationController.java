package edu.iu.otiwari.primesservice.controller;

import edu.iu.otiwari.primesservice.model.Customer;
import edu.iu.otiwari.primesservice.service.IAuthenticationService;
import edu.iu.otiwari.primesservice.service.IPrimesService;
import edu.iu.otiwari.primesservice.service.TokenService;
import org.apache.el.parser.Token;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class AuthenticationController {

    private final IAuthenticationService authenticationService;

    private final AuthenticationManager authenticationManager;

    private TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager,
                                    IAuthenticationService authenticationService,
                                    TokenService tokenService){
        this.authenticationManager = authenticationManager;
        this.authenticationService = authenticationService;
        this.tokenService = tokenService;

    }


    @PostMapping("/register")
    public Customer register(@RequestBody Customer customer){
        try {
            return authenticationService.register(customer);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody Customer customer){
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                customer.getUsername()
                                , customer.getPassword()));
        return tokenService.generateToken(authentication);

    }


}
