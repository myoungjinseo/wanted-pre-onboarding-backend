package com.wanted.api.web.employment.service;

import com.wanted.api.domain.employment.entity.Employment;
import com.wanted.api.domain.employment.repo.EmploymentRepository;
import com.wanted.api.web.employment.dto.EmploymentDetailPlusOrderIdResponse;
import com.wanted.api.web.employment.dto.EmploymentDetailResponse;
import com.wanted.api.web.employment.dto.EmploymentReadResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmploymentReadService {
    private final EmploymentRepository employmentRepository;
    private final EmploymentCreateService employmentCreateService;

    public List<EmploymentReadResponse> getEmployment() {
        return employmentRepository.findAllAndCompany();
    }
    public List<EmploymentReadResponse> searchEmployment(String search) {
        return employmentRepository.findSearchAndCompany(search);
    }
    public EmploymentDetailPlusOrderIdResponse detailEmployment(Long id){
        Employment employment = employmentCreateService.getId(id);
        EmploymentDetailResponse employmentDetailResponse = employmentRepository.findByEmploymentId(id);
        List<Long> orderId = employmentRepository.findByCompany(id,employment.getCompany());
        return EmploymentDetailPlusOrderIdResponse.from(employmentDetailResponse, orderId);

    }
}

