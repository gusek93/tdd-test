package com.example.tddtest.service;

import com.example.tddtest.domain.Member;
import com.example.tddtest.domain.MembershipType;
import com.example.tddtest.exception.MembershipErrorResult;
import com.example.tddtest.exception.MembershipException;
import com.example.tddtest.repository.MemberRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Builder
@RequiredArgsConstructor
class MemberResponse {
    private final Long id;
    private final MembershipType membershipType;
}

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponse addMember(final String userId, final MembershipType membershipType, final Integer point) {
        final Member result = memberRepository.finByUserMembershipType(userId, membershipType);
        if (result != null) {
            throw new MembershipException(MembershipErrorResult.DUPLICATED_MEMBERSHIP_REGISTER);
        }

        final Member member = Member.builder()
            .userId(userId)
            .point(point)
            .membershipType(membershipType)
            .build();

        final Member savedMember = memberRepository.save(member);

        return MemberResponse.builder()
            .id(savedMember.getId())
            .membershipType(savedMember.getMembershipType())
            .build();
    }
}
