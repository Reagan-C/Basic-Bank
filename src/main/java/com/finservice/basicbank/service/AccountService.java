package com.finservice.basicbank.service;

import com.finservice.basicbank.model.domain.Accounts;

public interface AccountService {
    Accounts getAccount(int id);
}
