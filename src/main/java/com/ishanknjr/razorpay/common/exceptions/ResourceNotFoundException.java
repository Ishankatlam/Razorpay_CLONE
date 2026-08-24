package com.ishanknjr.razorpay.common.exceptions;

import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private final String resourceName;
    private final Object identifier;


    public ResourceNotFoundException(String resourceName, Object identifier) {
        super(resourceName + "not found:" + identifier);
        this.resourceName = resourceName;
        this.identifier = identifier;
    }


}
