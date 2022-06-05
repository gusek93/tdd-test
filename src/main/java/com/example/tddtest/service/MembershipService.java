package com.example.tddtest.service;

import com.example.tddtest.domain.Membership;
import com.example.tddtest.domain.MembershipType;
import com.example.tddtest.exception.MembershipErrorResult;
import com.example.tddtest.exception.MembershipException;
import com.example.tddtest.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipService {

    private final MembershipRepository membershipRepository;

    public Membership addMembership(final String userId, final MembershipType membershipType, final Integer point) {
        final Membership result = membershipRepository.findByUserIdAndMembershipType(userId, membershipType);
        if (result != null) {
            throw new MembershipException(MembershipErrorResult.DUPLICATED_MEMBERSHIP_REGISTER);
        }
        return null;
    }
}
