package com.ishanknjr.razorpay.merchant.DTO.request.Reasponse;

import com.ishanknjr.razorpay.common.enums.Environment;

import java.time.LocalDateTime;
import java.util.UUID;

public record ApiKeyResponse(
        UUID id ,
        String KeyId,
        Environment environment,
        boolean enabled,
        LocalDateTime lastUsedAt,
        LocalDateTime createdAt
) {

}
