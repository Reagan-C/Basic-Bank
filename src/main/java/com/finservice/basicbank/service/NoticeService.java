package com.finservice.basicbank.service;

import com.finservice.basicbank.model.domain.Notices;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NoticeService {
    ResponseEntity<List<Notices>> getNotices();
}
