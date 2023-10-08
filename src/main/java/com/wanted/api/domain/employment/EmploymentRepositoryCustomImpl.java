package com.wanted.api.domain.employment;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.wanted.api.domain.employment.QEmployment.employment;
import static com.wanted.api.domain.company.QCompany.company;
@Repository
@RequiredArgsConstructor
public class EmploymentRepositoryCustomImpl implements EmploymentRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;


}
