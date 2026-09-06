package com.ishanknjr.razorpay.payment.Gateway.DTO;

import com.ishanknjr.razorpay.common.entity.Money;
import com.ishanknjr.razorpay.payment.Enums.PaymentMethod;

import java.util.Map;
import java.util.UUID;

public record PaymentRequest(
        UUID paymentId,
        UUID orderId,
        UUID merchantId,
        Money amount,
        PaymentMethod paymentMethod,
        Map<String , Object> methodDetails


) {

}
