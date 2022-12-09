package com.finservice.basicbank.service;

import com.finservice.basicbank.model.domain.Loans;

import java.util.List;

public interface LoanService {

    List<Loans> getLoanDetails(int id);
}

