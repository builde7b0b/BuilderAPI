package com.builderAPI.builder.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface JwtTokenRepository extends JpaRepository<InvalidJwtToken, Long> {

    Optional<InvalidJwtToken> findByToken(String token);
}
