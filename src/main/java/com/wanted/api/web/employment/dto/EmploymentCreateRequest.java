package com.wanted.api.web.employment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentCreateRequest {

    @Schema(description = "회사 id", example = "1")
    private Long companyId;

    @Schema(description = "채용 포지션", example = "백엔드 주니어 개발자")
    private String position;

    @Schema(description = "채용 보상금", example = "100000")
    private Long compensation;

    @Schema(description = "채용 내용", example = "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은 ...")
    private String content;

    @Schema(description = "사용 기술", example = "Python")
    private String skill;


}
