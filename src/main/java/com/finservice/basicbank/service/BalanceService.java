package com.finservice.basicbank.service;

import com.finservice.basicbank.model.domain.AccountTransactions;

import java.util.List;

public interface BalanceService {

    List<AccountTransactions> getBalance(int id);
}
