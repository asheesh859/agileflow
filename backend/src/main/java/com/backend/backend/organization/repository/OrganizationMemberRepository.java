package com.backend.backend.organization.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.organization.entity.OrganizationMember;

public interface OrganizationMemberRepository extends JpaRepository<OrganizationMember, Long> {
    List<OrganizationMember> findByUserId(Long userId);
    List<OrganizationMember> findByOrganizationId(Long organizationId);

    Optional<OrganizationMember> findByUserIdAndOrganizationId(Long userId, Long organizationId);
    boolean existsByOrganizationIdAndUserId(Long organizationId, Long userId);
    


}
