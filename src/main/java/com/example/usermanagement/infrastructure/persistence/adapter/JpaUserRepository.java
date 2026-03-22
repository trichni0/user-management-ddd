package com.example.usermanagement.infrastructure.persistence.adapter;

import com.example.usermanagement.domain.model.*;
import com.example.usermanagement.domain.repository.port.UserRepository;
import com.example.usermanagement.domain.valueobject.*;
import com.example.usermanagement.infrastructure.persistence.SpringDataUserRepository;
import com.example.usermanagement.infrastructure.persistence.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaUserRepository implements UserRepository {

    private final SpringDataUserRepository repo;

    public JpaUserRepository(SpringDataUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return repo.findByEmail(email.getValue())
                .map(this::toDomain);
    }

    @Override
    public Optional<User> findById(UserId id) {
        return repo.findById(id.value())
                .map(this::toDomain);
    }

    @Override
    public void save(User user) {
        repo.save(toEntity(user));
    }

    private User toDomain(UserEntity e) {
        return new User(
                new UserId(e.id),
                new Email(e.email),
                new Password(e.password)
        );
    }

    private UserEntity toEntity(User u) {
        UserEntity e = new UserEntity();
        e.id = u.getId().value();
        e.email = u.getEmail().getValue();
        e.password = u.getPassword().getValue();
        return e;
    }
}