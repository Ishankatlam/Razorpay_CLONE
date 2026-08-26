package com.ishanknjr.razorpay.merchant.controller;

import com.ishanknjr.razorpay.merchant.DTO.request.CreateApiKeyRequest;
import com.ishanknjr.razorpay.merchant.DTO.request.Reasponse.ApiKeyCreateResponse;
import com.ishanknjr.razorpay.merchant.DTO.request.Reasponse.ApiKeyResponse;
import com.ishanknjr.razorpay.merchant.Service.ApiKeyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/merchants/{merchantId}/api-keys")
@RequiredArgsConstructor
public class ApiKeyController {

    private final ApiKeyService  apiKeyService;

    @PostMapping // 201
    public ResponseEntity<ApiKeyCreateResponse> create(@PathVariable UUID merchantId , @Valid @RequestBody CreateApiKeyRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiKeyService.create(merchantId , request));
    }
    @GetMapping
    public ResponseEntity<List<ApiKeyResponse>> listByMerchant(@PathVariable  UUID merchantId)
    {
        return ResponseEntity.ok(apiKeyService.listByMerchant(merchantId));
    }

    @DeleteMapping("/keyId")
    public ResponseEntity<Void> revoke(@PathVariable UUID merchantId, @PathVariable UUID apiKeyId) {
        apiKeyService.revoke(merchantId , apiKeyId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{apiKeyId}/rotate")
    public ResponseEntity<ApiKeyCreateResponse> rotatekey(@PathVariable UUID merchantId, @PathVariable UUID apiKeyId) {
        return ResponseEntity.ok(apiKeyService.rotatekey(merchantId , apiKeyId));
    }

}
