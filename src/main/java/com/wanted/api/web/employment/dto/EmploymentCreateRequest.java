package com.wanted.api.web.employment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentCreateRequest {
    private Long companyId;

    private String position;



    private Long compensation;

    private String content;

    private String skill;


}
