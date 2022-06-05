package com.example.tddtest.repository;

import com.example.tddtest.domain.Membership;
import com.example.tddtest.domain.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
    Membership findByUserIdAndMembershipType(final String userId, final MembershipType membershipType);
}
