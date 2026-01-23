package com.audius.music.core.user.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(schema = "user_management", name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "created_on")
    private String createdOn;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "phone_number")
    private String phoneNumber;
}
