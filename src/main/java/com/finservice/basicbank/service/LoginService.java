package com.finservice.basicbank.service;

import com.finservice.basicbank.model.domain.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface LoginService {

    ResponseEntity<String> saveCustomer(Customer customer);

    Customer getUserDetails(Authentication authentication);
}
