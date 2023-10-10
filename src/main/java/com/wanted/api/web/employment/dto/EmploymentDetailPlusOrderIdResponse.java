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
        return  new EmploymentDetailPlusOrderIdResponse(
                employmentDetailResponse.getEmploymentId(),
                employmentDetailResponse.getCompanyName(),
                employmentDetailResponse.getCountry(),
                employmentDetailResponse.getRegion(),
                employmentDetailResponse.getPosition(),
                employmentDetailResponse.getCompensation(),
                employmentDetailResponse.getSkill(),
                employmentDetailResponse.getContent(),
                orderId
        );
    }

}
