package com.wanted.api.web.employment.service;

import com.wanted.api.domain.employment.EmploymentRepository;
import com.wanted.api.web.employment.dto.EmploymentDetailPlusOrderIdResponse;
import com.wanted.api.web.employment.dto.EmploymentDetailResponse;
import com.wanted.api.web.employment.dto.EmploymentReadResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class EmploymentReadService {
    private final EmploymentRepository employmentRepository;


    public List<EmploymentReadResponse> getEmployment() {
        return employmentRepository.findAllAndCompany().orElseThrow();
    }

    public List<EmploymentReadResponse> searchEmployment(String search) {
        return employmentRepository.findSearchAndCompany(search).orElseThrow();
    }

    public EmploymentDetailPlusOrderIdResponse detailEmployment(Long id){
        EmploymentDetailResponse employmentDetailResponse = employmentRepository.findByEmploymentId(id).orElseThrow();

        List<Long> orderId = employmentRepository.findByCompanyId(id).orElseThrow();
        EmploymentDetailPlusOrderIdResponse from = EmploymentDetailPlusOrderIdResponse.from(employmentDetailResponse, orderId);
        return from;
    }
}

