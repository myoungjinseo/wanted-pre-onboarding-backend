package com.wanted.api.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ErrorResponse  {
    private final String errorCode;
    private final String reason;
}
