package com.wanted.api.domain.employment;


import com.wanted.api.domain.company.Company;
import com.wanted.api.web.employment.dto.EmploymentDetailResponse;
import com.wanted.api.web.employment.dto.EmploymentReadResponse;

import java.util.List;
import java.util.Optional;

public interface EmploymentRepositoryCustom {
    List<EmploymentReadResponse> findAllAndCompany();
    List<EmploymentReadResponse> findSearchAndCompany(String search);
    List<Long> findByCompany(Long id, Company company);
    EmploymentDetailResponse findByEmploymentId(Long id);

}
