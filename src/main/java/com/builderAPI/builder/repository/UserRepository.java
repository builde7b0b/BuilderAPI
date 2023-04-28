package com.builderAPI.builder.repository;

import com.builderAPI.builder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
