package com.finservice.basicbank.controller;

import com.finservice.basicbank.model.domain.Customer;
import com.finservice.basicbank.repository.jpa.CustomerRepository;
import com.finservice.basicbank.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

   @Autowired
   private LoginService loginService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        return loginService.saveCustomer(customer);
    }

    @GetMapping("/user")
    public Customer getDetailsAfterLogin(Authentication authentication) {
        return loginService.getUserDetails(authentication);
    }
}
