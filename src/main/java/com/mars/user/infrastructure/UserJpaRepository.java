package com.mars.user.infrastructure;

import com.mars.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String username);

    Optional<User> findById(Long userId);
}
