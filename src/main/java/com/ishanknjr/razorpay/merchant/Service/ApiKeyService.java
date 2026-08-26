package com.ishanknjr.razorpay.merchant.Service;


import com.ishanknjr.razorpay.merchant.DTO.request.CreateApiKeyRequest;
import com.ishanknjr.razorpay.merchant.DTO.request.Reasponse.ApiKeyCreateResponse;
import com.ishanknjr.razorpay.merchant.DTO.request.Reasponse.ApiKeyResponse;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface ApiKeyService {
    ApiKeyCreateResponse create(UUID merchantId, @Valid CreateApiKeyRequest request);

    List<ApiKeyResponse> listByMerchant(UUID merchantId);

    void revoke(UUID merchantId, UUID apiKeyId);

    ApiKeyCreateResponse rotatekey(UUID merchantId, UUID apiKeyId);
}
