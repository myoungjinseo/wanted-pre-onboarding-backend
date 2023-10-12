package com.wanted.api.common.apiResponse;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponseDto<T> {
    private T data;

    public static <T> ResponseEntity<ApiResponseDto<T>> ok(T data) {
        return ResponseEntity.ok(new ApiResponseDto<T>(data));
    }

    public static <T> ResponseEntity<ApiResponseDto<T>> created(T data) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponseDto<T>(data));
    }

    public static ResponseEntity<Void> noContent() {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}