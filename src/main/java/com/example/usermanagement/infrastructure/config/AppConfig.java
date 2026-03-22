package com.example.usermanagement.infrastructure.config;

import com.example.usermanagement.application.usecase.RegisterUserUseCase;
import com.example.usermanagement.domain.repository.port.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    RegisterUserUseCase registerUserUseCase(UserRepository repo) {
        return new RegisterUserUseCase(repo);
    }
}