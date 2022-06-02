package com.example.tddtest.service;

import com.example.tddtest.domain.Member;
import com.example.tddtest.domain.MembershipType;
import com.example.tddtest.exception.MembershipErrorResult;
import com.example.tddtest.exception.MembershipException;
import com.example.tddtest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member addMember(final String userId, final MembershipType membershipType, final Integer point) {
        final Member result = memberRepository.finByUserMembershipType(userId, membershipType);
        if (result != null) {
            throw new MembershipException(MembershipErrorResult.DUPLICATED_MEMBERSHIP_REGISTER);
        }

        return null;
    }
}
