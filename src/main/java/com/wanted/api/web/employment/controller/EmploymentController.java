package com.wanted.api.web.employment.controller;

import com.wanted.api.common.apiResponse.ApiResponseDto;
import com.wanted.api.web.employment.dto.EmploymentCreateRequest;
import com.wanted.api.web.employment.dto.EmploymentCreateResponse;
import com.wanted.api.web.employment.dto.EmploymentUpdateRequest;
import com.wanted.api.web.employment.dto.EmploymentUpdateResponse;
import com.wanted.api.web.employment.service.EmploymentCreateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employment")
@RequiredArgsConstructor
@Tag(name = "Employment Controller",description = "Employment API")
public class EmploymentController {
    private final EmploymentCreateService employmentCreateService;

    @PostMapping()
    @Operation(summary = "채용공고 등록")
    public ResponseEntity<?> postEmployment(
            @RequestBody EmploymentCreateRequest employmentCreateRequest
    ) {
        EmploymentCreateResponse employmentCreateResponse = employmentCreateService.postEmployment(employmentCreateRequest);
        return ApiResponseDto.created(employmentCreateResponse);
    }
    @Operation(summary = "채용공고 수정")
    @PatchMapping("/{employmentId}")
    public ResponseEntity<?> updateEmployment(
            @PathVariable Long employmentId,
            @RequestBody EmploymentUpdateRequest employmentUpdateRequest
    ) {
        EmploymentUpdateResponse employmentUpdateResponse = employmentCreateService.updateEmployment(employmentId, employmentUpdateRequest);
        return ApiResponseDto.ok(employmentUpdateResponse);
    }
    @Operation(summary = "채용공고 삭제")
    @DeleteMapping("/{employmentId}")
    public ResponseEntity<Void> deleteEmployment(
            @PathVariable Long employmentId
    ) {
        employmentCreateService.deleteEmployment(employmentId);
        return ApiResponseDto.noContent();
    }
}
