package com.example.tddtest;

import com.example.tddtest.domain.Member;
import com.example.tddtest.domain.MembershipType;
import com.example.tddtest.exception.MembershipException;
import com.example.tddtest.repository.MemberRepository;
import com.example.tddtest.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    private final String userId = "userId";
    private final MembershipType membershipType = MembershipType.NAVER;
    private final Integer point = 10000;
    @InjectMocks
    private MemberService target;
    @Mock
    private MemberRepository memberRepository;

    @Test
    public void membershipAdd_fail_exist() {
        //given
        doReturn(Member.builder().build()).when(memberRepository).finByUserMembershipType(userId, membershipType);

        //when
        final MembershipException result = assertThrows(MembershipException.class, () -> target.addMember(userId, membershipType, point));
    }

    @Test
    public void create_member_success () {
        //given
        doReturn(null).when(memberRepository).finByUserMembershipType(userId, membershipType);
        doReturn(member()).when(memberRepository).save(any(Member.class));
    }

    private Object member() {
        return Member.builder()
            .id(-1L)
            .userId(userId)
            .point(point)
            .membershipType(membershipType.NAVER)
            .build();
    }
}
