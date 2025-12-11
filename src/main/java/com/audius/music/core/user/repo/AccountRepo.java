package com.audius.music.core.user.repo;

import com.audius.music.core.user.entity.Account;
import com.audius.music.core.user.entity.User;
import com.audius.music.core.user.entity.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
    Optional <Account> findByAccountId(Long accountId);
    Optional<Account> findByAccountName(String accountName);
    Optional <Account> findByUserId(Long id);
    Optional<Account> findByPhoneNumber(String phoneNumber);


}
