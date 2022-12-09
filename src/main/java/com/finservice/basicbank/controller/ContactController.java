package com.finservice.basicbank.controller;

import com.finservice.basicbank.model.domain.Contact;
import com.finservice.basicbank.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @Autowired
    private ContactService service;
    @PostMapping("/contact")
    public Contact saveContactInquiryDetails(@RequestParam Contact contact) {
        return service.saveEnquiryInfo(contact);
    }
}
