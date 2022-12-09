package com.finservice.basicbank.service.impl;

import com.finservice.basicbank.model.domain.Loans;
import com.finservice.basicbank.repository.jpa.LoanRepository;
import com.finservice.basicbank.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository repository;


    @Override
    public List<Loans> getLoanDetails(int id) {
        List<Loans> loans = repository.findByCustomerIdOrderByStartDateDesc(id);

        if (loans != null) {
            return  loans;
        } else {
            return null;
        }
    }
}
