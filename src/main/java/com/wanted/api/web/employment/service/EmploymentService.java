package com.wanted.api.web.employment.service;

import com.wanted.api.domain.company.Company;
import com.wanted.api.domain.company.CompanyRepository;
import com.wanted.api.domain.employment.Employment;
import com.wanted.api.domain.employment.EmploymentRepository;
import com.wanted.api.web.employment.dto.EmploymentRequest;
import com.wanted.api.web.employment.dto.EmploymentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class EmploymentService {

    private final EmploymentRepository employmentRepository;
    private final CompanyRepository companyRepository;

    @Transactional
    public EmploymentResponse postEmployment(EmploymentRequest employmentRequest) {

        Company company = companyRepository.findById(employmentRequest.getCompanyId()).orElseThrow();
        Employment employment = employmentRepository.save(Employment.builder()
                .position(employmentRequest.getPosition())
                .compensation(employmentRequest.getCompensation())
                .content(employmentRequest.getContent())
                .skill(employmentRequest.getSkill())
                .company(company)
                .build());
        return EmploymentResponse.from(employmentRequest.getCompanyId(), employment);
    }

    @Transactional
    public EmploymentResponse updateEmployment(Long employmentId, EmploymentRequest employmentRequest) {

        Company company = companyRepository.findById(employmentRequest.getCompanyId()).orElseThrow();
        Employment employment = employmentRepository.save(Employment.builder()
                .id(employmentId)
                .position(employmentRequest.getPosition())
                .compensation(employmentRequest.getCompensation())
                .content(employmentRequest.getContent())
                .skill(employmentRequest.getSkill())
                .company(company)
                .build());
        return EmploymentResponse.from(employmentRequest.getCompanyId(), employment);
    }



    public void deleteEmployment(Long employmentId) {
        Employment employment = employmentRepository.findById(employmentId).orElseThrow();

        employmentRepository.delete(employment);


    }
}
