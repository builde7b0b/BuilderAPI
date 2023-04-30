package com.builderAPI.builder.repository;

import com.builderAPI.builder.security.InvalidJwtToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JwtTokenRepository extends JpaRepository<InvalidJwtToken, Long> {

    Optional<InvalidJwtToken> findByToken(String token);
}
