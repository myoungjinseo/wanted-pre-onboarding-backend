package com.wanted.api.web.employment.controller;

import com.wanted.api.common.apiResponse.ApiResponse;
import com.wanted.api.web.employment.dto.EmploymentCreateRequest;
import com.wanted.api.web.employment.dto.EmploymentCreateResponse;
import com.wanted.api.web.employment.dto.EmploymentUpdateRequest;
import com.wanted.api.web.employment.dto.EmploymentUpdateResponse;
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
        return ApiResponse.created(employmentCreateResponse);
    }

    @PatchMapping("/{employmentId}")
    public ResponseEntity<?> updateEmployment(
            @PathVariable Long employmentId,
            @RequestBody EmploymentUpdateRequest employmentUpdateRequest
    ) {
        EmploymentUpdateResponse employmentUpdateResponse = employmentCreateService.updateEmployment(employmentId, employmentUpdateRequest);
        return ApiResponse.ok(employmentUpdateResponse);
    }

    @DeleteMapping("/{employmentId}")
    public ResponseEntity<Void> deleteEmployment(
            @PathVariable Long employmentId
    ) {
        employmentCreateService.deleteEmployment(employmentId);
        return ApiResponse.noContent();
    }
}
