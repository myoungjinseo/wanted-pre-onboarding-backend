package com.wanted.api.web.employment.service;

import com.wanted.api.domain.company.Company;
import com.wanted.api.domain.company.CompanyRepository;
import com.wanted.api.domain.employment.Employment;
import com.wanted.api.domain.employment.EmploymentRepository;
import com.wanted.api.web.employment.dto.EmploymentCreateRequest;
import com.wanted.api.web.employment.dto.EmploymentCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
public class EmploymentCreateService {

    private final EmploymentRepository employmentRepository;
    private final CompanyRepository companyRepository;

    @Transactional
    public EmploymentCreateResponse postEmployment(EmploymentCreateRequest employmentCreateRequest) {

        Company company = companyRepository.findById(employmentCreateRequest.getCompanyId()).orElseThrow();
        Employment employment = employmentRepository.save(Employment.builder()
                .position(employmentCreateRequest.getPosition())
                .compensation(employmentCreateRequest.getCompensation())
                .content(employmentCreateRequest.getContent())
                .skill(employmentCreateRequest.getSkill())
                .company(company)
                .build());
        return EmploymentCreateResponse.from(employmentCreateRequest.getCompanyId(), employment);
    }

    @Transactional
    public EmploymentCreateResponse updateEmployment(Long employmentId, EmploymentCreateRequest employmentCreateRequest) {

        Company company = companyRepository.findById(employmentCreateRequest.getCompanyId()).orElseThrow();
        Employment employment = employmentRepository.save(Employment.builder()
                .id(employmentId)
                .position(employmentCreateRequest.getPosition())
                .compensation(employmentCreateRequest.getCompensation())
                .content(employmentCreateRequest.getContent())
                .skill(employmentCreateRequest.getSkill())
                .company(company)
                .build());
        return EmploymentCreateResponse.from(employmentCreateRequest.getCompanyId(), employment);
    }



    public void deleteEmployment(Long employmentId) {
        Employment employment = employmentRepository.findById(employmentId).orElseThrow();

        employmentRepository.delete(employment);


    }
}
