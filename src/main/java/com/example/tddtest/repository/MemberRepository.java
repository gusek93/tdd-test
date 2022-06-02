package com.example.tddtest.repository;

import com.example.tddtest.domain.Member;
import com.example.tddtest.domain.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member finByUserMembershipType(final String userId, final MembershipType membershipType);
}
