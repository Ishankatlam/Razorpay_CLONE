package com.ishanknjr.razorpay.common.exceptions;

import lombok.Getter;

@Getter
 
public class DuplicateResourceException extends RuntimeException {
    public final String errorcode ;

    public DuplicateResourceException(String errorcode , String message) {
        super(message);
        this.errorcode = errorcode;
    }


}
