package com.ishanknjr.razorpay.merchant.Service.impl;

import com.ishanknjr.razorpay.common.exceptions.ResourceNotFoundException;
import com.ishanknjr.razorpay.merchant.DTO.request.CreateApiKeyRequest;
import com.ishanknjr.razorpay.merchant.DTO.request.Reasponse.ApiKeyCreateResponse;
import com.ishanknjr.razorpay.merchant.Repository.ApiKeyRepository;
import com.ishanknjr.razorpay.merchant.Repository.MerchantRepository;
import com.ishanknjr.razorpay.merchant.Service.ApiKeyService;
import com.ishanknjr.razorpay.merchant.entity.APIkeys;
import com.ishanknjr.razorpay.merchant.entity.Merchant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

//import static jdk.jpackage.internal.cli.OptionValue.build;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiKeyServiceImpl implements ApiKeyService {

    private final MerchantRepository merchantRepository;
    private final ApiKeyRepository apiKeyRepository;
    @Override
    public ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request) {
        Merchant merchant = merchantRepository.findById(merchantId)
                .orElseThrow(()-> new ResourceNotFoundException("merchant" , merchantId));

//         secure these key secrets again and store them and we will not alow you to see the key scret here\
        String keyId = "rzp_" + request.environment().name().toUpperCase() + " big random String ";
        String rawSecret ="big_random_secret"; // todorpace with encrypttt

        APIkeys apiKey = APIkeys.builder()
                .merchant(merchant)
                .keyId(keyId)
                .keySecretHash(rawSecret) // stored the encrypted secret
                .environment(request.environment())
                .build();

        apiKey = apiKeyRepository.save(apiKey);

        return new ApiKeyCreateResponse(apiKey.getId() , keyId , rawSecret ,request.environment()); // returned the raw secret
    }
}
