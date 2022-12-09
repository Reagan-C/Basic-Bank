package com.finservice.basicbank.controller;

import com.finservice.basicbank.model.domain.Notices;
import com.finservice.basicbank.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoticesController {

    @Autowired
    private NoticeService service;
    @GetMapping("/notices")
    public ResponseEntity<List<Notices>> getNotice() {
        return service.getNotices();
    }
}
