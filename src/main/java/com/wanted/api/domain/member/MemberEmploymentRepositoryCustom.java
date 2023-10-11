package com.wanted.api.domain.member;


import com.wanted.api.domain.employment.Employment;


public interface MemberEmploymentRepositoryCustom {
    boolean exitsMemberEmployment(Employment employment, Member member);

}
