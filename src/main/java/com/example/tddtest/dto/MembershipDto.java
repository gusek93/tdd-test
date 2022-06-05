package com.example.tddtest.dto;

import com.example.tddtest.domain.MembershipType;
import lombok.Builder;


@Builder
public class MembershipDto {

    private String userId;
    private Integer point;
    private MembershipType membershipType;

}
