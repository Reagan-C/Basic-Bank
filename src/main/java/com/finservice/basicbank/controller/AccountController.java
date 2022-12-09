package com.finservice.basicbank.controller;

import com.finservice.basicbank.model.domain.Accounts;
import com.finservice.basicbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam int id) {
        return accountService.getAccount(id);
    }
}
