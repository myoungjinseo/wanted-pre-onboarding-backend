package com.wanted.api.domain.employment;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wanted.api.web.employment.dto.EmploymentDetailResponse;
import com.wanted.api.web.employment.dto.EmploymentReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.wanted.api.domain.employment.QEmployment.employment;
import static com.wanted.api.domain.company.QCompany.company;

@Repository
@RequiredArgsConstructor
public class EmploymentRepositoryCustomImpl implements EmploymentRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<List<EmploymentReadResponse>> findAllAndCompany() {
        return Optional.ofNullable(
                jpaQueryFactory.select(Projections.fields(EmploymentReadResponse.class,
                                employment.id.as("employmentId"), company.name.as("companyName")
                                , company.country, company.region
                                , employment.position, employment.compensation, employment.skill))
                        .from(employment)
                        .fetch()
        );
    }

    @Override
    public Optional<List<EmploymentReadResponse>> findSearchAndCompany(String search) {
        return Optional.ofNullable(
                jpaQueryFactory.select(Projections.fields(EmploymentReadResponse.class,
                                employment.id.as("employmentId"), company.name.as("companyName")
                                , company.country, company.region
                                , employment.position, employment.compensation, employment.skill))
                        .from(employment)
                        .where(company.name.contains(search)
                                .or(company.country.contains(search))
                                .or(company.region.contains(search))
                                .or(employment.position.contains(search))
                                .or(employment.skill.contains(search)))
                        .fetch()
        );
    }

    @Override
    public Optional<List<Long>> findByCompanyId(Long id){
        return Optional.ofNullable(
          jpaQueryFactory.select(company.id)
                  .from(employment)
                  .where(employment.id.eq(id))
                  .fetch()
        );
    }

    @Override
    public Optional<EmploymentDetailResponse> findByEmploymentId(Long id){
        return Optional.ofNullable(
                jpaQueryFactory.select(Projections.fields(EmploymentDetailResponse.class,
                        employment.id.as("employmentId"), company.name.as("companyName")
                        , company.country, company.region
                        , employment.position, employment.compensation, employment.skill,employment.content))
                        .from(employment)
                        .where(employment.id.eq(id))
                        .fetchOne()
        );
    }

}
