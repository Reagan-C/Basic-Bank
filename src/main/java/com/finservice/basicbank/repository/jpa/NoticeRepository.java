package com.finservice.basicbank.repository.jpa;

import com.finservice.basicbank.model.domain.Notices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notices, Integer> {

    @Query(value = "from Notices n where CURRENT_DATE BETWEEN noticeBeginDate AND noticeEndDate")
    List<Notices> findAllActiveNotices();

}
