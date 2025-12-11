package com.audius.music.core.user.repo;

import com.audius.music.core.user.entity.User;
import com.audius.music.core.user.entity.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccessRepo extends JpaRepository<UserAccess, Long> {
    Optional <UserAccess> findByUserAccessId(Long id);
    Optional<UserAccess> findByUserId(Long userId);
    Optional<UserAccess> findByPhoneNumber(String phoneNumber);

}
