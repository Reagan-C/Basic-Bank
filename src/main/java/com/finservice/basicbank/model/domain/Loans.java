package com.finservice.basicbank.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "loans")
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_number")
    private int loanNumber;

    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "loan_type", nullable = false)
    private  String loanType;

    @Column(name = "total_loan", nullable = false)
    private int totalLoan;

    @Column(name = "amount_paid", nullable = false)
    private int amountPaid;

    @Column(name = "outstanding_amount", nullable = false)
    private int outstandingAmount;

    @Column(name = "created_on")
    private Date createdOn;
}
