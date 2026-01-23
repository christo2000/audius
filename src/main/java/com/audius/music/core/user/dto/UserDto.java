package com.audius.music.core.user.dto;


import java.sql.Timestamp;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String userName;
    private String password;
    private String mail;
    private String createdOn;
    private String accountName;
    private String phoneNumber;
    private LocalDate dob;

    public UserDto(Long userId, String userName, String password, String mail, String createdOn,
                      String accountName, String phoneNumber, LocalDate dob){
        this.userId = userId;
        this.userName = userName;
        this.password= password;
        this.mail = mail;
        this.createdOn = createdOn;
        this.accountName = accountName;
        this.phoneNumber = phoneNumber;
        this.dob= dob;

    }


}

