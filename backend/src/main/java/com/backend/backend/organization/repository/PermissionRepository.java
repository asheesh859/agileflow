package com.backend.backend.organization.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.organization.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{
        Optional<Permission> findByName(String name);

}
