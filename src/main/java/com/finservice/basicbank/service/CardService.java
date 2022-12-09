package com.finservice.basicbank.service;

import com.finservice.basicbank.model.domain.Cards;

import java.util.List;

public interface CardService {

    List<Cards> getCardDetails(int id);
}
