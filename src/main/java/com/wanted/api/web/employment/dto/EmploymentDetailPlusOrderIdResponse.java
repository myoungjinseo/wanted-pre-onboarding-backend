package com.wanted.api.web.employment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "채용 공고 id")
    private Long employmentId;
    @Schema(description = "회사 이름")
    private String companyName;
    @Schema(description = "국가")
    private String country;
    @Schema(description = "지역")
    private String region;
    @Schema(description = "채용 포지션")
    private String position;
    @Schema(description = "채용 보상금")
    private Long compensation;
    @Schema(description = "사용 기술")
    private String skill;
    @Schema(description = "채용 내용")
    private String content;
    @Schema(description = "회사가 올린 다른 채용 공고")
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
