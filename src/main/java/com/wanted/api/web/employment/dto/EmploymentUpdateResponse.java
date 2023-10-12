package com.wanted.api.web.employment.dto;

import com.wanted.api.domain.employment.entity.Employment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentUpdateResponse {
    @Schema(description = "채용 포지션")
    private String position;

    @Schema(description = "채용 보상금")
    private Long compensation;
    @Schema(description = "채용 내용")
    private String content;
    @Schema(description = "사용 기술")
    private String skill;

    public static EmploymentUpdateResponse from(Employment employment) {
        return new EmploymentUpdateResponse(

                employment.getPosition(),
                employment.getCompensation(),
                employment.getContent(),
                employment.getSkill()
        );
    }
}
