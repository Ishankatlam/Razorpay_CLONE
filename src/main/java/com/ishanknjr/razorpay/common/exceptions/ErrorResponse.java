package com.ishanknjr.razorpay.common.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
        String errorcode ,
        String errorDescription,
        LocalDateTime timestamp,
        List<FeildError> fieldErrors
) {
    public record FeildError(String feild  , String message) {

    }
    public static ErrorResponse of(String errorcode , String errorDescription) {
        return new ErrorResponse(errorcode, errorDescription, LocalDateTime.now(), null);
    }

    public static ErrorResponse of(String errorcode , String errorDescription , List<FeildError> fieldErrors) {
        return new ErrorResponse(errorcode, errorDescription, LocalDateTime.now(), null);
    }
}
