package com.finservice.basicbank.service.impl;

import com.finservice.basicbank.model.domain.Customer;
import com.finservice.basicbank.repository.jpa.CustomerRepository;
import com.finservice.basicbank.service.LoginService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    @Transactional
    public ResponseEntity<String> saveCustomer(Customer customer) {
        Customer savedCustomer = null;
        ResponseEntity response = null;

        try {
            String hashPassword = encoder.encode(customer.getPassword());
            customer.setPassword(hashPassword);
            customer.setCreatedOn(new Date(System.currentTimeMillis()));
            savedCustomer = customerRepository.save(customer);
            if (savedCustomer.getId() > 0) {
                response = ResponseEntity.status(HttpStatus.CREATED)
                        .body("User registration successful");
            }
        }catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception was thrown due to " + e.getMessage());
        }
        return response;
    }

    @Override
    public Customer getUserDetails(Authentication authentication) {
        List<Customer> customers = customerRepository.findByEmail(authentication.getName());
        if (customers.size() > 0) {
            return customers.get(0);
        }else {
            return null;
        }
    }

}
