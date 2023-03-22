package com.sixthou.blogsearchstandalone.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INVALID_PARAMETER_ERROR(HttpStatus.BAD_REQUEST.value(), "Invalid parameter error"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error");

    private final int code;
    private final String message;
}
