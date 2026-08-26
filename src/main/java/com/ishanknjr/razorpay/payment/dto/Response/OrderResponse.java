package com.ishanknjr.razorpay.payment.dto.Response;

import com.ishanknjr.razorpay.common.entity.Money;
import com.ishanknjr.razorpay.common.enums.orderstatus;
import com.ishanknjr.razorpay.payment.Enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public record OrderResponse(
        UUID id,
        UUID merchant ,
        String receipt,
        Money amount,
        OrderStatus orderStatus,
        Integer attempts ,
        Map<String , Object> notes ,
        LocalDateTime expiresAt,
           LocalDateTime createdAt
) {


}
