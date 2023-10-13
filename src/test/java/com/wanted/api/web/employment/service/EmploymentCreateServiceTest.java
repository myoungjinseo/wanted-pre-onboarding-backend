package com.wanted.api.web.employment.service;


import com.wanted.api.domain.company.entity.Company;
import com.wanted.api.domain.company.repo.CompanyRepository;
import com.wanted.api.domain.employment.entity.Employment;
import com.wanted.api.domain.employment.repo.EmploymentRepository;
import com.wanted.api.web.employment.dto.EmploymentCreateRequest;
import com.wanted.api.web.employment.dto.EmploymentCreateResponse;
import com.wanted.api.web.employment.dto.EmploymentUpdateRequest;
import com.wanted.api.web.employment.dto.EmploymentUpdateResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@SuppressWarnings("NonAsciiCharacters")
@ExtendWith(SpringExtension.class)
@SpringBootTest
class EmploymentCreateServiceTest {


    @Autowired
    EmploymentCreateService employmentCreateService;

    @Autowired
    EmploymentRepository employmentRepository;
    @Autowired
    CompanyRepository companyRepository;
    private Employment employment;
    private Company company;

    @BeforeEach
    void setUp() {
        company = companyRepository.findById(1L).get();
        employment = employmentRepository.save(Employment.builder()
                .position("백엔드 주니어 개발자")
                .compensation(1000000L)
                .content("원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..")
                .skill("Django")
                .company(company)
                .build());

    }

    @Transactional
    @Test
    void 채용공고를_생성합니다() {

        final EmploymentCreateRequest request = new EmploymentCreateRequest(1L, "백엔드 주니어 개발자", 100000L, "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..", "Python");

        final EmploymentCreateResponse response = employmentCreateService.postEmployment(request);

        assertThat(response.getCompanyId()).isNotNull();

    }

    @Transactional
    @Test
    void 채용공고를_수정합니다() {

        final EmploymentUpdateRequest request = new EmploymentUpdateRequest("백엔드 주니어 개발자", 1500000L, "원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은..", "Python");

        final EmploymentUpdateResponse response = employmentCreateService.updateEmployment(employment.getId(),request);
        final Employment employment = employmentRepository.findById(response.getEmploymentId()).get();
        assertAll(
                () -> assertThat(response.getEmploymentId()).isEqualTo(employment.getId()),
                () -> assertThat(employment.getCompensation()).isEqualTo(1500000L),
                () -> assertThat(employment.getContent()).isEqualTo("원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은.."),
                () -> assertThat(employment.getPosition()).isEqualTo("백엔드 주니어 개발자"),
                () -> assertThat(employment.getSkill()).isEqualTo("Python")
        );


    }

    @Transactional
    @Test
    void 채용공고를_삭제합니다() {
        employmentCreateService.deleteEmployment(employment.getId());
        assertThatThrownBy(() -> {
            employmentCreateService.getId(employment.getId());
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("해당 채용 공고를 찾을 수 없습니다.");
    }
}