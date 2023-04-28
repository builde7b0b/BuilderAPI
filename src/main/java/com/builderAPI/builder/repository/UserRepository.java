package com.builderAPI.builder.repository;

import com.builderAPI.builder.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
