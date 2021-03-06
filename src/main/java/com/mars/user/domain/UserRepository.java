package com.mars.user.domain;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);

    Optional<User> findById(Long userId);

    Long save(User user);
}
