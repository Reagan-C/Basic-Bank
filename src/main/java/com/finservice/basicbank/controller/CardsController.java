package com.finservice.basicbank.controller;

import com.finservice.basicbank.model.domain.Cards;
import com.finservice.basicbank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardService service;

    @GetMapping("/myCards")
    public List<Cards> getCardsDetails(@RequestParam int id) {
        return service.getCardDetails(id);
    }
}
