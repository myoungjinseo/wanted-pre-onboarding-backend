package com.wanted.api.web.employment.controller;

import com.wanted.api.common.apiResponse.ApiResponse;
import com.wanted.api.web.employment.dto.EmploymentDetailPlusOrderIdResponse;
import com.wanted.api.web.employment.dto.EmploymentDetailResponse;
import com.wanted.api.web.employment.dto.EmploymentReadResponse;
import com.wanted.api.web.employment.service.EmploymentReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class EmploymentReadController {
    private final EmploymentReadService employmentReadService;
    @GetMapping("/findAll")
    public ResponseEntity<?> getEmployment(){
        List<EmploymentReadResponse> employment = employmentReadService.getEmployment();
        return ApiResponse.ok(employment);
    }

    @GetMapping("/some/url")
    public ResponseEntity<?> searchEmployment(
            @RequestParam String search
    ){
        List<EmploymentReadResponse> employment = employmentReadService.searchEmployment(search);
        return ApiResponse.ok(employment);
    }

    @GetMapping("/some/detail/{id}")
    public ResponseEntity<?> detailEmployment(
            @PathVariable Long id
    ){
        EmploymentDetailPlusOrderIdResponse employment = employmentReadService.detailEmployment(id);
        return ApiResponse.ok(employment);
    }
}
