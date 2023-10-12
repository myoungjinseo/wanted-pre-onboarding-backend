package com.wanted.api.web.employment.service;

import com.wanted.api.common.exception.ErrorCode;
import com.wanted.api.common.exception.ErrorException;
import com.wanted.api.domain.company.entity.Company;
import com.wanted.api.domain.company.repo.CompanyRepository;
import com.wanted.api.domain.employment.entity.Employment;
import com.wanted.api.domain.employment.repo.EmploymentRepository;
import com.wanted.api.web.company.service.CompanyService;
import com.wanted.api.web.employment.dto.EmploymentCreateRequest;
import com.wanted.api.web.employment.dto.EmploymentCreateResponse;
import com.wanted.api.web.employment.dto.EmploymentUpdateRequest;
import com.wanted.api.web.employment.dto.EmploymentUpdateResponse;
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
    private final CompanyService companyService;

    @Transactional
    public EmploymentCreateResponse postEmployment(EmploymentCreateRequest employmentCreateRequest) {
        Company company = companyService.getId(employmentCreateRequest.getCompanyId());
        Employment employment = employmentRepository.save(Employment.builder()
                .position(employmentCreateRequest.getPosition())
                .compensation(employmentCreateRequest.getCompensation())
                .content(employmentCreateRequest.getContent())
                .skill(employmentCreateRequest.getSkill())
                .company(company)
                .build());
        return EmploymentCreateResponse.from(employmentCreateRequest.getCompanyId(), employment);
    }

    @Transactional(readOnly = true)
    public Employment getId(Long employmentId) {

        return employmentRepository.findById(employmentId)
                .orElseThrow(() -> new ErrorException(ErrorCode.NOT_FOUND_EMPLOYMENT));
    }

    @Transactional
    public EmploymentUpdateResponse updateEmployment(Long employmentId, EmploymentUpdateRequest employmentUpdateRequest) {
        Employment employment = getId(employmentId);

        employment.update(employmentUpdateRequest);
        log.info("update Employment {}", employmentId);

        return EmploymentUpdateResponse.from(employment);
    }
    @Transactional
    public void deleteEmployment(Long employmentId) {

        employmentRepository.deleteById(employmentId);
        log.info("delete Employment {}", employmentId);
    }
}
