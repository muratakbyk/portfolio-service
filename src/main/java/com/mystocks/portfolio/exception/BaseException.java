package com.mystocks.portfolio.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BaseException extends RuntimeException{

    private final int errorCode;
    private final String errorMessage;
}
