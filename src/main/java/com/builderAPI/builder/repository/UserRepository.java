package com.builderAPI.builder.repository;

import com.builderAPI.builder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing user data.
 *
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {


}
