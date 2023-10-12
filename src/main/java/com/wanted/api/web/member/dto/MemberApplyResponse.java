package com.wanted.api.web.member.dto;


import com.wanted.api.domain.member.MemberEmployment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberApplyResponse {
    @Schema(description = "채용공고 id")
    private Long employmentId;

    @Schema(description = "사용자 id")
    private Long memberId;

    public static MemberApplyResponse from(MemberEmployment memberEmployment) {
        return new MemberApplyResponse(
                memberEmployment.getMember().getId(),
                memberEmployment.getEmployment().getId()
        );
    }
}
