package com.wanted.api.web.employment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmploymentDetailResponse {
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



}
