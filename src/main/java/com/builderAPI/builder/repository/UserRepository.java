package com.builderAPI.builder.repository;

import com.builderAPI.builder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing user data.
 *
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}
