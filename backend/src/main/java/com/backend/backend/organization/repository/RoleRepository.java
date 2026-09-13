package com.backend.backend.organization.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.organization.entity.Role;

public interface RoleRepository extends JpaRepository<Role , Long>{
    Optional<Role> findByName(String name);
}
