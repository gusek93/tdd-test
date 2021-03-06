package com.example.tddtest.repository;

import com.example.tddtest.domain.MembershipType;
import com.example.tddtest.domain.Membership;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MembershipRepositoryTest {

    @Autowired
    private MembershipRepository membershipRepository;

//    @Test
//    public void MmbershipRepository가null이아님() {
//        assertThat(membershipRepository).isNotNull();
//    }

    @Test
    public void 멤버십등록() {

        //given
        final Membership membership = Membership.builder()
                .userId("userId")
                .membershipType(MembershipType.NAVER)
                .point(10000)
                .build();

        //when
        final Membership result = membershipRepository.save(membership);

        //then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getUserId()).isEqualTo("userId");
        assertThat(result.getMembershipType()).isEqualTo(MembershipType.NAVER);
        assertThat(result.getPoint()).isEqualTo(10000);
    }

    @Test
    public void 멤버십이존재하는지테스트() {
        //given
        final Membership membership = Membership.builder()
                .userId("userId")
                .membershipType(MembershipType.NAVER)
                .point(10000)
                .build();

        //when
        membershipRepository.save(membership);
        final Membership findResult = membershipRepository.findByUserIdAndMembershipType("userId", MembershipType.NAVER);

        //then
        assertThat(findResult.getId()).isNotNull();
        assertThat(findResult.getUserId()).isEqualTo("userId");
        assertThat(findResult.getMembershipType()).isEqualTo(MembershipType.NAVER);
        assertThat(findResult.getPoint()).isEqualTo(10000);
    }

    @Test
    public void 멤버십조회_사이즈가0() {

        //when
        List<Membership> result = membershipRepository.findAllByUserId("userID");

        //then
        assertThat(result.size()).isEqualTo(0);

    }

    @Test
    public void 멤버십조회_사이즈가2() {

        //given
        final Membership naverMemberhsip = Membership.builder()
                .userId("userId")
                .membershipType(MembershipType.NAVER)
                .point(10000)
                .build();

        final Membership kakaoMembership = Membership.builder()
                .userId("userId")
                .membershipType(MembershipType.KAKAO)
                .point(10000)
                .build();

        membershipRepository.save(naverMemberhsip);
        membershipRepository.save(kakaoMembership);

        //when
        List<Membership> result = membershipRepository.findAllByUserId("userId");

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}