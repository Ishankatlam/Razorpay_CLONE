package com.ishanknjr.razorpay.merchant.DTO.request.Reasponse;

import com.ishanknjr.razorpay.common.enums.Environment;

import java.util.UUID;

public record ApiKeyCreateResponse(
        UUID id,
        String keyId,
        String keySecret,
        Environment environment

) {
}
