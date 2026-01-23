package com.audius.music.core.user.controller;


import com.audius.music.core.user.dto.UserDto;
import com.audius.music.core.user.entity.User;
import com.audius.music.core.user.repo.AccountRepo;
import com.audius.music.core.user.repo.UserAccessRepo;
import com.audius.music.core.user.repo.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Optional;

@RestController
public class UserController {
    private AccountRepo accountRepo;
    private UserRepo userRepo;
    private UserAccessRepo userAccessRepo;

    UserController(AccountRepo accountRepo, UserRepo userRepo, UserAccessRepo userAccessRepo){
        this.accountRepo = accountRepo;
        this.userRepo = userRepo;
        this.userAccessRepo = userAccessRepo;
    }

    @GetMapping("/Get/userData/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {

        return userRepo.findByUserId(userId)
                .map(user -> new UserDto(
                        user.getUserId(),
                        user.getUserName(),
                        user.getPassword(),
                        user.getMail(),
                        LocalDate.now().toString(),
                        user.getAccountName(),
                        user.getPhoneNumber(),
                        user.getDob()
                ))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
