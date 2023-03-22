package com.sixthou.blogsearchstandalone.common.handler;

import com.sixthou.blogsearchstandalone.common.ErrorCode;
import com.sixthou.blogsearchstandalone.dto.common.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    protected ResponseEntity<ErrorResponse> handleValidException(Exception e) {
        return makeErrorResponse(ErrorCode.INVALID_PARAMETER_ERROR);
    }

    @ExceptionHandler({RestClientException.class})
    protected ResponseEntity<ErrorResponse> handleRestException(Exception e) {
        return makeErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleAllException(Exception e) {
        return makeErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> makeErrorResponse(ErrorCode errorCode) {
        return ResponseEntity
                .status(errorCode.getCode())
                .body(ErrorResponse.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build());
    }


}
