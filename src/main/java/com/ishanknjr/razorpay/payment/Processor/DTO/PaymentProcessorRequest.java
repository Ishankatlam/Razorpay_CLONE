package com.ishanknjr.razorpay.payment.Processor.DTO;

import com.ishanknjr.razorpay.common.entity.Money;
import com.ishanknjr.razorpay.payment.Enums.PaymentMethod;

import java.util.Map;

public record PaymentProcessorRequest(
        PaymentMethod method,
        Money amount,
        Map<String , Object> methodDetails
) {

}
