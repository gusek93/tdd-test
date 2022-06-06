package com.example.tddtest.dto;

import com.example.tddtest.domain.MembershipType;
import lombok.Builder;
import lombok.Getter;

import javax.swing.*;
import java.time.LocalDateTime;

@Builder
public class MembershipDto {

    private Long id;
    private String userId;
    private Integer point;
    private MembershipType membershipType;

}
