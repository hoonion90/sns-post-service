package com.fehoon.sns.post.common.api;

import lombok.Getter;

@Getter
public enum ServiceExceptionCode {
    ;

    private final String errorCode;
    private final String message;

    ServiceExceptionCode(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return "errorCode=" + errorCode + ", message=" + message;
    }
}
