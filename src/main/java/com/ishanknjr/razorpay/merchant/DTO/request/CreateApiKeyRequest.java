package com.ishanknjr.razorpay.merchant.DTO.request;

import com.ishanknjr.razorpay.common.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment

) {
}
