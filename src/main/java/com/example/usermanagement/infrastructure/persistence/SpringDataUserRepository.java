package com.example.usermanagement.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);
}