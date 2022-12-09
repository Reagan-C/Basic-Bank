package com.finservice.basicbank.service.impl;

import com.finservice.basicbank.model.domain.Cards;
import com.finservice.basicbank.repository.jpa.CardsRepository;
import com.finservice.basicbank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardsRepository repository;

    @Override
    public List<Cards> getCardDetails(int id) {
        List<Cards> cards = repository.findByCustomerId(id);
        if (cards != null) {
            return cards;
        } else {
            return null;
        }
    }
}
