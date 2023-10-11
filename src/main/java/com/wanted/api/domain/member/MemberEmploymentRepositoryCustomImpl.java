package com.wanted.api.domain.member;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wanted.api.domain.employment.Employment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import static com.wanted.api.domain.member.QMember.member;
import static com.wanted.api.domain.member.QMemberEmployment.memberEmployment;

@Repository
@RequiredArgsConstructor
public class MemberEmploymentRepositoryCustomImpl implements MemberEmploymentRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public boolean exitsMemberEmployment(Employment employment, Member member) {
        return jpaQueryFactory.selectFrom(memberEmployment)
                .where(memberEmployment.employment.eq(employment).and(memberEmployment.member.eq(member)))
                .fetchOne() != null;
    }


}
