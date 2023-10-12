package com.wanted.api.web.member.service;

import com.wanted.api.common.exception.ErrorCode;
import com.wanted.api.common.exception.ErrorException;
import com.wanted.api.domain.employment.entity.Employment;

import com.wanted.api.domain.member.entity.Member;
import com.wanted.api.domain.member.entity.MemberEmployment;
import com.wanted.api.domain.member.repo.MemberEmploymentRepository;
import com.wanted.api.domain.member.repo.MemberRepository;
import com.wanted.api.web.employment.service.EmploymentCreateService;
import com.wanted.api.web.member.dto.MemberApplyRequest;
import com.wanted.api.web.member.dto.MemberApplyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberApplyService {
    private final MemberEmploymentRepository memberEmploymentRepository;
    private final MemberRepository memberRepository;
    private final EmploymentCreateService employmentCreateService;
    public Member findMember(Long id){
        return  memberRepository.findById(id)
                .orElseThrow(() -> new ErrorException(ErrorCode.NOT_FOUND_MEMBER));
    }

    @Transactional
    public MemberApplyResponse apply(MemberApplyRequest memberApplyRequest, Long employmentId){
        Member member = findMember(memberApplyRequest.getMemberId());
        Employment employment = employmentCreateService.getId(employmentId);
        boolean employment1 = memberEmploymentRepository.exitsMemberEmployment(employment,member);
        if(employment1){
            throw new ErrorException(ErrorCode.EXITS_MEMBER);
        }
        MemberEmployment apply = MemberEmployment.builder()
                .employment(employment)
                .member(member)
                .build();

        memberEmploymentRepository.save(apply);
        return MemberApplyResponse.from(apply);

    }

}
