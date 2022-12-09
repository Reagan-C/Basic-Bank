package com.finservice.basicbank.service.impl;

import com.finservice.basicbank.model.domain.Accounts;
import com.finservice.basicbank.repository.jpa.AccountsRepository;
import com.finservice.basicbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountsRepository repository;
    @Override
    public Accounts getAccount(int id) {
        return repository.findByCustomerId(id);
    }
}
