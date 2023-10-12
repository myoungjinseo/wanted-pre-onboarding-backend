package com.wanted.api.domain.employment.repo;


import com.wanted.api.domain.company.entity.Company;
import com.wanted.api.web.employment.dto.EmploymentDetailResponse;
import com.wanted.api.web.employment.dto.EmploymentReadResponse;

import java.util.List;

public interface EmploymentRepositoryCustom {
    List<EmploymentReadResponse> findAllAndCompany();
    List<EmploymentReadResponse> findSearchAndCompany(String search);
    List<Long> findByCompany(Long id, Company company);
    EmploymentDetailResponse findByEmploymentId(Long id);

}
