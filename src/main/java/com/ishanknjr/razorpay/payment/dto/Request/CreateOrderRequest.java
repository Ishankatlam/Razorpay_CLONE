package com.ishanknjr.razorpay.payment.dto.Request;

import com.ishanknjr.razorpay.common.entity.Money;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Map;

public record CreateOrderRequest(
        @NotNull(message = "Amount is required")
        Money amount ,
        @Size(max =100 , message = "Receipt must not exceed 100 characters")
        String receipt,

        @Size(max = 100)
//order id known to merchant
        Map<String , Object> notes ,
//        user phone  , address , order id , item it , various types of information
        LocalDateTime expiresAt  // 30 minutes 10 minutes
) {

}
