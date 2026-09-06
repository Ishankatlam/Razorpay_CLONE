package com.ishanknjr.razorpay.payment.dto.Request;

import com.ishanknjr.razorpay.payment.Enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;

import java.util.Map;
import java.util.UUID;


public record PaymentInitRequestDTO(
        @NotNull(message = "Order Id is required")
        UUID orderId,

        @NotNull(message = "Payment Id is Required")
        PaymentMethod paymentMethod,

        Map<String, Object> methodDetails
) {
}
