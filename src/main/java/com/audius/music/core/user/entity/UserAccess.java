package com.audius.music.core.user.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(schema = "user_management", name = "user_access")
public class UserAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_access_id")
    private Long userAccessId;
    @Column(name = "user_role")
    private String userRole;
    @Column(name = "created_on")
    private String createdOn;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "phone_number")
    private String phoneNumber;
}
