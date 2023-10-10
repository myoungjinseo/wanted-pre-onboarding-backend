package com.wanted.api.web.member.dto;


import com.wanted.api.domain.member.MemberEmployment;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberApplyResponse {
    private Long employmentId;
    private Long memberId;

    public static MemberApplyResponse from(MemberEmployment memberEmployment) {
        return new MemberApplyResponse(
                memberEmployment.getMember().getId(),
                memberEmployment.getEmployment().getId()
        );
    }
}
