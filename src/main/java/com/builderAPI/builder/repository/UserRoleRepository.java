package com.builderAPI.builder.repository;

import com.builderAPI.builder.model.User;
import com.builderAPI.builder.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<User, Long> {
    UserRole save(UserRole userRole);
}
