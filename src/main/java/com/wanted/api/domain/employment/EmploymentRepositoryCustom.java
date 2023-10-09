package com.wanted.api.domain.employment;


import com.wanted.api.web.employment.dto.EmploymentDetailResponse;
import com.wanted.api.web.employment.dto.EmploymentReadResponse;

import java.util.List;
import java.util.Optional;

public interface EmploymentRepositoryCustom {
    Optional<List<EmploymentReadResponse>> findAllAndCompany();
    Optional<List<EmploymentReadResponse>> findSearchAndCompany(String search);
    Optional<List<Long>> findByCompanyId(Long id);
    Optional<EmploymentDetailResponse> findByEmploymentId(Long id);

}
