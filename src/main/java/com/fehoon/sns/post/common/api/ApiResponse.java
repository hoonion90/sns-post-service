package com.fehoon.sns.post.common.api;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
public class ApiResponse<T> {

    private final Boolean result;
    private final Error error;
    private final T message;

    public ApiResponse(
            Boolean result,
            String errorCode,
            String errorMessage,
            T message
    ){
        this.result = result;
        this.error = Error.builder()
                .errorCode(errorCode)
                .errorMessage(errorMessage)
                .build();
        this.message = message;
    }

    public static <T> ApiResponse<T> success(T message){
        return new ApiResponse<>(true, null, null, message);
    }

    public static <T> ResponseEntity<ApiResponse<T>> serviceException(String errorCode, String ErrorMessage){
        return ResponseEntity.status(500).body(new ApiResponse<>(false, errorCode, ErrorMessage, null));
    }

    public static <T> ResponseEntity<ApiResponse<T>> responseException(String errorCode, String errorMessage){
        return ResponseEntity.ok(new ApiResponse<>(false, errorCode, errorMessage, null));
    }

    public static <T> ResponseEntity<ApiResponse<T>> validException(String errorCode, String errorMessage){
        return ResponseEntity.ok(new ApiResponse<>(false, errorCode, errorMessage, null));
    }

    public static <T> ResponseEntity<ApiResponse<T>> serverException(String code, String errorMessage) {
        return ResponseEntity.status(500)
                .body(new ApiResponse<>(false, code, errorMessage, null));
    }

    @Getter
    public static class Error{
        private final String errorCode;
        private final String errorMessage;

        @Builder
        public Error(String errorCode, String errorMessage){
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }
    }

}
