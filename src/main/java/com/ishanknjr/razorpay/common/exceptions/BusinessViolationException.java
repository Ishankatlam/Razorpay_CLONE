package com.ishanknjr.razorpay.common.exceptions;

import lombok.Getter;

@Getter
public class BusinessViolationException  extends RuntimeException{
    public final String errorcode ;

    public BusinessViolationException(String errorcode , String message) {
        super(message);
        this.errorcode = errorcode;
    }

}
