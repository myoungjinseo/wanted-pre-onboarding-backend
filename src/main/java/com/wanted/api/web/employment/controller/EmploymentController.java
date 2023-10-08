package com.wanted.api.web.employment.controller;

import com.wanted.api.web.employment.dto.EmploymentRequest;
import com.wanted.api.web.employment.dto.EmploymentResponse;
import com.wanted.api.web.employment.service.EmploymentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmploymentController {
    private final EmploymentService employmentService;

    @PostMapping()
    public ResponseEntity<?> postEmployment(
            @RequestBody EmploymentRequest employmentRequest
    ) {
        EmploymentResponse employmentResponse = employmentService.postEmployment(employmentRequest);
        return ResponseEntity.ok().body(employmentResponse);
    }

    @PatchMapping("/{employmentId}")
    public ResponseEntity<?> updateEmployment(
            @PathVariable Long employmentId,
            @RequestBody EmploymentRequest employmentRequest
    ) {
        EmploymentResponse employmentResponse = employmentService.updateEmployment(employmentId,employmentRequest);
        return ResponseEntity.ok().body(employmentResponse);
    }

    @DeleteMapping("/{employmentId}")
    public ResponseEntity<?> deleteEmployment(
            @PathVariable Long employmentId
    ) {
        employmentService.deleteEmployment(employmentId);
        return ResponseEntity.ok().body("완료");
    }
}
