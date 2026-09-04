package com.ishanknjr.razorpay.payment.dto.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ishanknjr.razorpay.common.entity.Money;
import com.ishanknjr.razorpay.payment.Enums.PaymentMethod;
import com.ishanknjr.razorpay.payment.Enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL) // remove all the feilds that are null and give all the ot null to the endpoints
public record PaymentResponse(

        UUID id ,
        UUID orderId,
        UUID merchantId,
        Money amount,
        PaymentStatus status,
        PaymentMethod method,
        Map<String  , Object > methodDetails,
        String cardLastFour,
        String cardBrand,
        String bankReference,
        String errorCode,
        String errorDescription,
        Long refundedAmountPaise,
        LocalDateTime capturedAt,
        LocalDateTime createdAt


) {


}
