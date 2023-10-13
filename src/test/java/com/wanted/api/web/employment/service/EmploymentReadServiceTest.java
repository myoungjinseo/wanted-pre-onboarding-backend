package com.wanted.api.web.employment.service;

import com.wanted.api.domain.company.entity.Company;
import com.wanted.api.domain.company.repo.CompanyRepository;
import com.wanted.api.domain.employment.entity.Employment;
import com.wanted.api.domain.employment.repo.EmploymentRepository;
import com.wanted.api.web.employment.dto.EmploymentDetailPlusOrderIdResponse;
import com.wanted.api.web.employment.dto.EmploymentReadResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@SuppressWarnings("NonAsciiCharacters")
@ExtendWith(SpringExtension.class)
@SpringBootTest
class EmploymentReadServiceTest {


    @Autowired
    EmploymentReadService employmentReadService;

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
        employment = employmentRepository.save(Employment.builder()
                .position("백엔드 주니어 개발자")
                .compensation(1500000L)
                .content("원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..")
                .skill("Spring")
                .company(company)
                .build());
    }

    @Transactional(readOnly = true)
    @Test
    void 모든_채용공고_조회합니다() {
        final List<EmploymentReadResponse> responses = employmentReadService.getEmployment();
        assertAll(
                () -> assertThat(responses).hasSize(2),
                () -> assertThat(responses.get(0).getCompensation()).isEqualTo(1000000L),
                () -> assertThat(responses.get(0).getSkill()).isEqualTo("Django"),
                () -> assertThat(responses.get(1).getCompensation()).isEqualTo(1500000L),
                () -> assertThat(responses.get(1).getSkill()).isEqualTo("Spring")
        );
    }

    @Transactional(readOnly = true)
    @Test
    void 채용공고를_검색합니다() {
        final Company company2 = companyRepository.findById(2L).get();
        final Employment employment2 = employmentRepository.save(Employment.builder()
                .position("백엔드 주니어 개발자")
                .compensation(100000L)
                .content("원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..")
                .skill("Spring")
                .company(company2)
                .build());
        employmentRepository.save(employment2);

        final List<EmploymentReadResponse> responses = employmentReadService.searchEmployment("Sp");
        assertAll(
                () -> assertThat(responses.get(0).getEmploymentId()).isEqualTo(2L),
                () -> assertThat(responses.get(0).getCompanyName()).isEqualTo("원티드"),
                () -> assertThat(responses.get(0).getCountry()).isEqualTo("한국"),
                () -> assertThat(responses.get(0).getRegion()).isEqualTo("서울"),
                () -> assertThat(responses.get(0).getPosition()).isEqualTo("백엔드 주니어 개발자"),
                () -> assertThat(responses.get(0).getCompensation()).isEqualTo(1500000L),
                () -> assertThat(responses.get(0).getSkill()).isEqualTo("Spring"),

                () -> assertThat(responses.get(1).getEmploymentId()).isEqualTo(3L),
                () -> assertThat(responses.get(1).getCompanyName()).isEqualTo("네이버"),
                () -> assertThat(responses.get(1).getCountry()).isEqualTo("한국"),
                () -> assertThat(responses.get(1).getRegion()).isEqualTo("판교"),
                () -> assertThat(responses.get(1).getPosition()).isEqualTo("백엔드 주니어 개발자"),
                () -> assertThat(responses.get(1).getCompensation()).isEqualTo(100000L),
                () -> assertThat(responses.get(1).getSkill()).isEqualTo("Spring")

        );
    }

    @Transactional(readOnly = true)
    @Test
    void 채용공고_상세페이지_조회합니다() {
        final Employment employment2 = employmentRepository.save(Employment.builder()
                .position("백엔드 주니어 개발자")
                .compensation(100000L)
                .content("원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..")
                .skill("Spring")
                .company(company)
                .build());
        employmentRepository.save(employment2);

        final EmploymentDetailPlusOrderIdResponse response = employmentReadService.detailEmployment(2L);
        assertAll(
                () -> assertThat(response.getEmploymentId()).isEqualTo(2L),
                () -> assertThat(response.getCompanyName()).isEqualTo("원티드"),
                () -> assertThat(response.getCountry()).isEqualTo("한국"),
                () -> assertThat(response.getRegion()).isEqualTo("서울"),
                () -> assertThat(response.getPosition()).isEqualTo("백엔드 주니어 개발자"),
                () -> assertThat(response.getCompensation()).isEqualTo(1500000L),
                () -> assertThat(response.getSkill()).isEqualTo("Spring"),
                () -> assertThat(response.getOrderId()).isEqualTo(List.of(1L,3L))
        );
    }
}