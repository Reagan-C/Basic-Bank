package com.finservice.basicbank.service.impl;

import com.finservice.basicbank.model.domain.AccountTransactions;
import com.finservice.basicbank.repository.jpa.AccountTransactionsRepository;
import com.finservice.basicbank.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private AccountTransactionsRepository repository;

    @Override
    public List<AccountTransactions> getBalance(int id) {
        List<AccountTransactions> accountTransactions = repository.findByCustomerIdOrderByTransactionDateDesc(id);
        if (accountTransactions != null) {
            return accountTransactions;
        } else {
            return null;
        }
    }
}
