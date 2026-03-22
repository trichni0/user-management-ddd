package com.example.usermanagement.interfaces.rest;

import com.example.usermanagement.application.usecase.RegisterUserUseCase;
import com.example.usermanagement.interfaces.rest.dto.RegisterRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final RegisterUserUseCase useCase;

    public UserController(RegisterUserUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public String register(@RequestBody RegisterRequest req) {
        return useCase.execute(req.email(), req.password());
    }
}