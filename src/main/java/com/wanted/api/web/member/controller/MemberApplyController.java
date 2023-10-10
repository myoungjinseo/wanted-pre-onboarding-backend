package com.wanted.api.web.member.controller;


import com.wanted.api.web.member.dto.MemberApplyRequest;
import com.wanted.api.web.member.dto.MemberApplyResponse;
import com.wanted.api.web.member.service.MemberApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class MemberApplyController {

private final MemberApplyService memberApplyService;
    @PostMapping("/some/detail/{id}/apply")
    public ResponseEntity<?> apply(
            @PathVariable Long id,
            @RequestBody MemberApplyRequest memberApplyRequest
            ){
        MemberApplyResponse apply = memberApplyService.apply(memberApplyRequest, id);
        return ResponseEntity.ok().body(apply);
    }
}
