package com.finservice.basicbank.service;

import com.finservice.basicbank.model.domain.Contact;

public interface ContactService {

    Contact saveEnquiryInfo(Contact contact);

    String getServiceReqNumber();
}
