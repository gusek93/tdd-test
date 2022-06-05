package com.example.tddtest.service;


import com.example.tddtest.domain.MembershipType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class MembershipRequest {
    private final Integer point;
    private final MembershipType membershipType;
}
