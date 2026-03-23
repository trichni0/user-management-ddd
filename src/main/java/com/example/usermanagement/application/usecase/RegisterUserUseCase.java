package com.example.usermanagement.application.usecase;

import com.example.usermanagement.domain.model.*;
import com.example.usermanagement.domain.repository.port.UserRepository;
import com.example.usermanagement.domain.valueobject.*;

import java.util.UUID;

public class RegisterUserUseCase implements RegisterUserUseCasePort {

    private final UserRepository repository;

    public RegisterUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public String execute(String email, String password) {

        Email userEmail = new Email(email);

        repository.findByEmail(userEmail)
                .ifPresent(u -> {
                    throw new RuntimeException("User already exists");
                });

        User user = new User(
                new UserId(UUID.randomUUID().toString()),
                userEmail,
                new Password(password)
        );

        repository.save(user);

        return user.getId().value();
    }
}