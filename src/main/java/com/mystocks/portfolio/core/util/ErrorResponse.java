package com.mystocks.portfolio.core.util;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
    private int status;
    private String errorCode;
    private String errorMessage;

    public static ErrorResponse of(int status, String errorCode, String errorMessage) {
        return ErrorResponse.builder()
                .status(status)
                .errorCode(errorCode)
                .errorMessage(errorMessage)
                .build();
    }
}
