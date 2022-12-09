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
@Table(name = "accounts")
public class Accounts {
    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @Id
    @Column(name = "account_number", nullable = false)
    private int accountNumber;

    @Column(name = "account_type", nullable = false)
    private String accountType;

    @Column(name = "branch_address", nullable = false)
    private String branchAddress;

    @Column(name = "created_on")
    private Date createdOn;
}
