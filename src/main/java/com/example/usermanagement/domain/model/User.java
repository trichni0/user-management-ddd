package com.example.usermanagement.domain.model;

import com.example.usermanagement.domain.valueobject.Email;
import com.example.usermanagement.domain.valueobject.Password;

public class User {

    private final UserId id;
    private Email email;
    private Password password;
    private UserStatus status;
    private int failedLoginAttempts;

    public User(UserId id, Email email, Password password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.status = UserStatus.ACTIVE;
        this.failedLoginAttempts = 0;
    }

    public void changePassword(Password newPassword) {
        if (status != UserStatus.ACTIVE) {
            throw new IllegalStateException("User not active");
        }
        this.password = newPassword;
    }

    public void recordFailedLogin() {
        failedLoginAttempts++;
        if (failedLoginAttempts >= 3) {
            status = UserStatus.LOCKED;
        }
    }

    public void resetLoginAttempts() {
        failedLoginAttempts = 0;
    }

    public UserId getId() { return id; }
    public Email getEmail() { return email; }
    public Password getPassword() { return password; }
}