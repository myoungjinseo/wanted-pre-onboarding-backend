package com.wanted.api.web.employment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmploymentDetailPlusOrderIdResponse {
    private Long employmentId;
    private String companyName;
    private String country;
    private String region;
    private String position;
    private Long compensation;
    private String skill;
    private String content;
    private List<Long> orderId;

    public static EmploymentDetailPlusOrderIdResponse from(EmploymentDetailResponse employmentDetailResponse, List<Long> orderId) {
        return  EmploymentDetailPlusOrderIdResponse.builder()
                .employmentId(employmentDetailResponse.getEmploymentId())
                .companyName(employmentDetailResponse.getCompanyName())
                .country(employmentDetailResponse.getCountry())
                .region(employmentDetailResponse.getRegion())
                .position(employmentDetailResponse.getPosition())
                .compensation(employmentDetailResponse.getCompensation())
                .skill(employmentDetailResponse.getSkill())
                .content(employmentDetailResponse.getContent())
                .orderId(orderId)
                .build();

    }

}
