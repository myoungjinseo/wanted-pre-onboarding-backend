package com.wanted.api.web.employment.dto;

import com.wanted.api.domain.employment.Employment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentResponse {
    private Long companyId;

    private String position;


    private Long compensation;

    private String content;

    private String skill;

    public static EmploymentResponse from(Long companyId, Employment employment) {
        return new EmploymentResponse(
                companyId,
                employment.getPosition(),
                employment.getCompensation(),
                employment.getContent(),
                employment.getSkill()
        );
    }
}
