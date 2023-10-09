package com.wanted.api.web.employment.controller;

import com.wanted.api.web.employment.dto.EmploymentCreateRequest;
import com.wanted.api.web.employment.dto.EmploymentCreateResponse;
import com.wanted.api.web.employment.service.EmploymentCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmploymentController {
    private final EmploymentCreateService employmentCreateService;

    @PostMapping()
    public ResponseEntity<?> postEmployment(
            @RequestBody EmploymentCreateRequest employmentCreateRequest
    ) {
        EmploymentCreateResponse employmentCreateResponse = employmentCreateService.postEmployment(employmentCreateRequest);
        return ResponseEntity.ok().body(employmentCreateResponse);
    }

    @PatchMapping("/{employmentId}")
    public ResponseEntity<?> updateEmployment(
            @PathVariable Long employmentId,
            @RequestBody EmploymentCreateRequest employmentCreateRequest
    ) {
        EmploymentCreateResponse employmentCreateResponse = employmentCreateService.updateEmployment(employmentId, employmentCreateRequest);
        return ResponseEntity.ok().body(employmentCreateResponse);
    }

    @DeleteMapping("/{employmentId}")
    public ResponseEntity<String> deleteEmployment(
            @PathVariable Long employmentId
    ) {
        employmentCreateService.deleteEmployment(employmentId);
        return ResponseEntity.ok().body("삭제 완료");
    }
}
