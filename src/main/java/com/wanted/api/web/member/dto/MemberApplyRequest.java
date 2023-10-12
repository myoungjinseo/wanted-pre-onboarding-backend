package com.wanted.api.web.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberApplyRequest {
    @Schema(description = "사용자 id", example = "1")
    private Long memberId;
    @Schema(description = "사용자 이름", example = "서명진")
    private String name;
}
