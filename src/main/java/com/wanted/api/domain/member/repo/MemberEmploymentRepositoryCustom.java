package com.wanted.api.domain.member.repo;


import com.wanted.api.domain.employment.entity.Employment;
import com.wanted.api.domain.member.entity.Member;


public interface MemberEmploymentRepositoryCustom {
    boolean exitsMemberEmployment(Employment employment, Member member);

}
