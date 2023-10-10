package com.wanted.api.web.employment.dto;

import com.wanted.api.domain.employment.Employment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentUpdateResponse {

    private String position;


    private Long compensation;

    private String content;

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
