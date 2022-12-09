package com.finservice.basicbank.controller;

import com.finservice.basicbank.model.domain.AccountTransactions;
import com.finservice.basicbank.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam int id) {
        return balanceService.getBalance(id);
    }
}
