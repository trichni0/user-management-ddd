package com.example.usermanagement.interfaces.rest;

import com.example.usermanagement.application.usecase.RegisterUserUseCasePort;
import com.example.usermanagement.interfaces.rest.dto.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final RegisterUserUseCasePort useCase;

    public UserController(RegisterUserUseCasePort useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public String register(@Valid @RequestBody RegisterRequest req) {
        return useCase.execute(req.email(), req.password());
    }
}