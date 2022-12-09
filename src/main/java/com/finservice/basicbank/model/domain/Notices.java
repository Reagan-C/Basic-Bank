package com.finservice.basicbank.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "notices")
public class Notices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private int noticeId;

    @Column(name = "notice_summary", nullable = false)
    private String noticeSummary;

    @Column(name = "notice_details", nullable = false)
    private String noticeDetails;

    @Column(name = "notice_begin_date", nullable = false)
    private Date noticeBeginDate;

    @Column(name = "notice_end_date", nullable = false)
    private Date noticeEndDate;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_on")
    private Date updatedOn;

}
