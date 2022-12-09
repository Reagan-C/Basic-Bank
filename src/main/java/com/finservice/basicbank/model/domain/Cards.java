package com.finservice.basicbank.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "cards")
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private int cardId;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @Column(name = "card_type", nullable = false)
    private String cardType;

    @Column(name = "total_limit", nullable = false)
    private  int totalLimit;

    @Column(name = "amount_used", nullable = false)
    private int amountUsed;

    @Column(name = "available_amount", nullable = false)
    private int availableAmount;

    @Column(name = "created_on")
    private Date createdOn;
}
