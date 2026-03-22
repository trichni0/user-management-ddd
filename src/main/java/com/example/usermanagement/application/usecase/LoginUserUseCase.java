package com.example.usermanagement.application.usecase;

import com.example.usermanagement.domain.model.User;
import com.example.usermanagement.domain.repository.port.UserRepository;
import com.example.usermanagement.domain.valueobject.Email;

public class LoginUserUseCase {

    private final UserRepository repository;

    public LoginUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String email, String password) {

        User user = repository.findByEmail(new Email(email))
                .orElseThrow();

        if (!user.getPassword().getValue().equals(password)) {
            user.recordFailedLogin();
            repository.save(user);
            throw new RuntimeException("Invalid credentials");
        }

        user.resetLoginAttempts();
        repository.save(user);
    }
}