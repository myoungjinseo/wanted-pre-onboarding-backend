package com.wanted.api.domain.employment.repo;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wanted.api.domain.company.entity.Company;
import com.wanted.api.web.employment.dto.EmploymentDetailResponse;
import com.wanted.api.web.employment.dto.EmploymentReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.wanted.api.domain.employment.entity.QEmployment.employment;
import static com.wanted.api.domain.company.entity.QCompany.company;

@Repository
@RequiredArgsConstructor
public class EmploymentRepositoryCustomImpl implements EmploymentRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<EmploymentReadResponse> findAllAndCompany() {
        return jpaQueryFactory.select(Projections.fields(EmploymentReadResponse.class,
                                employment.id.as("employmentId"), company.name.as("companyName")
                                , company.country, company.region
                                , employment.position, employment.compensation, employment.skill))
                        .from(employment)
                        .fetch();
    }

    @Override
    public List<EmploymentReadResponse> findSearchAndCompany(String search) {
        return jpaQueryFactory.select(Projections.fields(EmploymentReadResponse.class,
                                employment.id.as("employmentId"), company.name.as("companyName")
                                , company.country, company.region
                                , employment.position, employment.compensation, employment.skill))
                        .from(employment)
                        .where(company.name.contains(search)
                                .or(company.country.contains(search))
                                .or(company.region.contains(search))
                                .or(employment.position.contains(search))
                                .or(employment.skill.contains(search)))
                        .fetch();
    }

    @Override
    public List<Long> findByCompany(Long id , Company company) {
        return jpaQueryFactory.select(employment.id)
                .from(employment)
                .where(employment.id.ne(id).and(employment.company.eq(company)))
                .fetch();
    }

    @Override
    public EmploymentDetailResponse findByEmploymentId(Long id) {
        return jpaQueryFactory.select(Projections.fields(EmploymentDetailResponse.class,
                                employment.id.as("employmentId"), company.name.as("companyName")
                                , company.country, company.region
                                , employment.position, employment.compensation, employment.skill, employment.content))
                        .from(employment)
                        .where(employment.id.eq(id))
                        .fetchOne();
    }

}
