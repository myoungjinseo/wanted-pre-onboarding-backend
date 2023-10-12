package com.wanted.api.domain.member.repo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wanted.api.domain.employment.entity.Employment;
import com.wanted.api.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import static com.wanted.api.domain.member.entity.QMemberEmployment.memberEmployment;

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
