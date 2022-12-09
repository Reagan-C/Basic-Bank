package com.finservice.basicbank.controller;

import com.finservice.basicbank.model.domain.Loans;
import com.finservice.basicbank.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoanService service;
    @GetMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestParam int id) {
        return service.getLoanDetails(id);
    }
}
