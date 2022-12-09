package com.finservice.basicbank.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "account_transactions")
public class AccountTransactions {
    @Id
    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(name = "account_number", nullable = false)
    private int accountNumber;

    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @Column(name = "transaction_date", nullable = false)
    private Date transactionDate;

    @Column(name = "transaction_summary", nullable = false)
    private String transactionSummary;

    @Column(name = "transaction_type", nullable = false)
    private String transactionType;

    @Column(name = "transaction_amount", nullable = false)
    private int transactionAmount;

    @Column(name = "closing_balance", nullable = false)
    private int closingBalance;

    @Column(name = "created_on")
    private Date createdOn;
}
