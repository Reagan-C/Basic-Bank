package com.finservice.basicbank.repository.jpa;

import com.finservice.basicbank.model.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
}
