package com.ishanknjr.razorpay.merchant.controller;

import com.ishanknjr.razorpay.merchant.DTO.request.Reasponse.MerchantReasponse;
import org.springframework.http.HttpStatus;

public class ReasponseEntity<T> {
    public static ReasponseEntity<MerchantReasponse> status(HttpStatus created){
        return null;
    }

    public ReasponseEntity<T> body() {
        return null;
    }
}
