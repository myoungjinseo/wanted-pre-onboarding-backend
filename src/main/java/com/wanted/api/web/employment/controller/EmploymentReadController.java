package com.wanted.api.web.employment.controller;

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
    public ResponseEntity<List<EmploymentReadResponse>> getEmployment(){
        List<EmploymentReadResponse> employment = employmentReadService.getEmployment();
        return ResponseEntity.ok().body(employment);
    }

    @GetMapping("/some/url")
    public ResponseEntity<List<EmploymentReadResponse>> searchEmployment(
            @RequestParam String search
    ){
        List<EmploymentReadResponse> employment = employmentReadService.searchEmployment(search);
        return ResponseEntity.ok().body(employment);
    }

    @GetMapping("/some/detail/{id}")
    public ResponseEntity<?> detailEmployment(
            @PathVariable Long id
    ){
        EmploymentDetailPlusOrderIdResponse employment = employmentReadService.detailEmployment(id);
        return ResponseEntity.ok().body(employment);
    }
}
