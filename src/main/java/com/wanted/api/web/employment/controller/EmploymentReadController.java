package com.wanted.api.web.employment.controller;

import com.wanted.api.common.apiResponse.ApiResponseDto;
import com.wanted.api.web.employment.dto.EmploymentDetailPlusOrderIdResponse;
import com.wanted.api.web.employment.dto.EmploymentReadResponse;
import com.wanted.api.web.employment.service.EmploymentReadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
@Tag(name = "Employment Read Controller",description = "Employment GET API")
public class EmploymentReadController {
    private final EmploymentReadService employmentReadService;
    @GetMapping("/findAll")
    @Operation(summary = "채용공고 목록")
    public ResponseEntity<?> getEmployment(){
        List<EmploymentReadResponse> employment = employmentReadService.getEmployment();
        return ApiResponseDto.ok(employment);
    }

    @GetMapping("/some/url")
    @Operation(summary = "채용공고 검색")
    public ResponseEntity<?> searchEmployment(
            @RequestParam String search
    ){
        List<EmploymentReadResponse> employment = employmentReadService.searchEmployment(search);
        return ApiResponseDto.ok(employment);
    }
    @Operation(summary = "채용 상세 페이지")
    @GetMapping("/some/detail/{id}")
    public ResponseEntity<?> detailEmployment(
            @PathVariable Long id
    ){
        EmploymentDetailPlusOrderIdResponse employment = employmentReadService.detailEmployment(id);
        return ApiResponseDto.ok(employment);
    }
}
