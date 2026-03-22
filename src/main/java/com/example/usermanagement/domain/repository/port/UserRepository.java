package com.example.usermanagement.domain.repository.port;

import com.example.usermanagement.domain.model.*;
import com.example.usermanagement.domain.valueobject.Email;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(UserId id);

    Optional<User> findByEmail(Email email);

    void save(User user);
}