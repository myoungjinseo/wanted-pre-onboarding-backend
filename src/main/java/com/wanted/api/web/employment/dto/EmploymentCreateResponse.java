package com.wanted.api.web.employment.dto;

import com.wanted.api.domain.employment.Employment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentCreateResponse {
    private Long companyId;

    private String position;


    private Long compensation;

    private String content;

    private String skill;

    public static EmploymentCreateResponse from(Long companyId, Employment employment) {
        return new EmploymentCreateResponse(
                companyId,
                employment.getPosition(),
                employment.getCompensation(),
                employment.getContent(),
                employment.getSkill()
        );
    }
}
