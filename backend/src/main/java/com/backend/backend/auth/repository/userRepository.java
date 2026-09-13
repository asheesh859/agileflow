package com.backend.backend.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.auth.entity.User;

public interface userRepository extends JpaRepository<User, Long>{
    
}
