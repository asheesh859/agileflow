package com.backend.backend.organization.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.organization.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    boolean existsBySlug(String slug);
    Optional<Organization> findBySlug(String slug);
}
