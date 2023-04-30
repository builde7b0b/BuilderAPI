package com.builderAPI.builder.security;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "invalid_jwt_token")
public class InvalidJwtToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token")
    private String token;

    @Column(name = "invalidated_at")
    private LocalDateTime invalidatedAt;

    public InvalidJwtToken() {
    }

    public InvalidJwtToken(Long id, String token, LocalDateTime invalidatedAt) {
        this.id = id;
        this.token = token;
        this.invalidatedAt = invalidatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getInvalidatedAt() {
        return invalidatedAt;
    }

    public void setInvalidatedAt(LocalDateTime invalidatedAt) {
        this.invalidatedAt = invalidatedAt;
    }


    //constructors, getters and setters


}
