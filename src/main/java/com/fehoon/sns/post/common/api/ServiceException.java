package com.fehoon.sns.post.common.api;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private String errorCode;
    private String message;

    public ServiceException(){
    }

    public ServiceException(ServiceExceptionCode response) {
        super(response.getMessage());
        this.errorCode = response.getErrorCode();
        this.message = super.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
