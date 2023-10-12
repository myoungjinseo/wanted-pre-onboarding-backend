package com.wanted.api.web.member.controller;


import com.wanted.api.web.member.dto.MemberApplyRequest;
import com.wanted.api.web.member.dto.MemberApplyResponse;
import com.wanted.api.web.member.service.MemberApplyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
@Tag(name = "Member Apply Controller",description = "Member Apply API")
public class MemberApplyController {

private final MemberApplyService memberApplyService;

    @Operation(summary = "채용공고 지원")
    @PostMapping("/some/detail/{id}/apply")
    public ResponseEntity<?> apply(
            @PathVariable Long id,
            @RequestBody MemberApplyRequest memberApplyRequest
            ){
        MemberApplyResponse apply = memberApplyService.apply(memberApplyRequest, id);
        return ResponseEntity.ok().body(apply);
    }
}
