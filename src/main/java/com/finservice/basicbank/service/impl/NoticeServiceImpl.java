package com.finservice.basicbank.service.impl;

import com.finservice.basicbank.model.domain.Notices;
import com.finservice.basicbank.repository.jpa.NoticeRepository;
import com.finservice.basicbank.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository repository;


    @Override
    public ResponseEntity<List<Notices>> getNotices() {
        List<Notices> notices = repository.findAllActiveNotices();
        if (notices != null) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices);
        } else {
            return null;
        }
    }
}
