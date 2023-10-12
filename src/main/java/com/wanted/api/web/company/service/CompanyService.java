package com.wanted.api.web.company.service;

import com.wanted.api.common.exception.ErrorCode;
import com.wanted.api.common.exception.ErrorException;
import com.wanted.api.domain.company.entity.Company;
import com.wanted.api.domain.company.repo.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    public Company getId(Long companyId){
        return  companyRepository.findById(companyId)
                .orElseThrow(() -> new ErrorException(ErrorCode.NOT_FOUND_COMPANY));
    }
}
