package com.wanted.api.web.employment.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmploymentUpdateRequest {

    private String position;



    private Long compensation;

    private String content;

    private String skill;

}
