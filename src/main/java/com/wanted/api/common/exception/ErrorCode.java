package com.wanted.api.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 415 에러
    BAD_REQUEST_PARAM(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),

    // 404 에러
    NOT_FOUND_EMPLOYMENT(HttpStatus.NOT_FOUND,"해당 채용 공고를 찾을 수 없습니다."),
    NOT_FOUND_COMPANY(HttpStatus.NOT_FOUND,"채용 공고에 작성된 회사를 찾을 수 없습니다."),
    NOT_FOUND_MEMBER(HttpStatus.NOT_FOUND,"사용자가 존재하지 않습니다."),
    // 500 에러
    NON_EXISTENT_DATA(HttpStatus.BAD_REQUEST,"존재하지 않는 데이터입니다."),

    INVALID_VARIABLE(HttpStatus.BAD_REQUEST,"잘못된 변수입니다."),
    EXITS_MEMBER(HttpStatus.BAD_REQUEST,"이미 지원한 멤버입니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
