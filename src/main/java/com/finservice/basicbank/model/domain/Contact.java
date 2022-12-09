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
@Table(name = "contact_messages")
public class Contact {

    @Id
    @Column(name = "contact_id", nullable = false)
    private String contactId;

    @Column(name = "contact_name", nullable = false)
    private String contactName;

    @Column(name = "contact_email", nullable = false)
    private String contactEmail;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "created_on")
    private Date createdOn;

}
