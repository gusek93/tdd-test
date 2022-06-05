package com.example.tddtest.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
class ErrorResponse {
    private final String Code;
    private final String message;
}
