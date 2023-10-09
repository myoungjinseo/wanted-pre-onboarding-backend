package com.wanted.api.web.employment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentReadResponse {
    private Long employmentId;
    private String companyName;
    private String country;
    private String region;
    private String position;
    private Long compensation;
    private String skill;

}
