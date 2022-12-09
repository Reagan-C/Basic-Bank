package com.finservice.basicbank.service.impl;

import com.finservice.basicbank.model.domain.Contact;
import com.finservice.basicbank.repository.jpa.ContactRepository;
import com.finservice.basicbank.service.ContactService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository repository;

    @Override
    @Transactional
    public Contact saveEnquiryInfo(Contact contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreatedOn(new Date(System.currentTimeMillis()));
        return repository.save(contact);
    }

    @Override
    public String getServiceReqNumber() {
        Random random = new Random();
        int randNumber = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + randNumber;
    }
}
