package com.finservice.basicbank.repository.jpa;

import com.finservice.basicbank.model.domain.AccountTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionsRepository extends JpaRepository<AccountTransactions, String> {

    List<AccountTransactions> findByCustomerIdOrderByTransactionDateDesc(int customerId);
}
