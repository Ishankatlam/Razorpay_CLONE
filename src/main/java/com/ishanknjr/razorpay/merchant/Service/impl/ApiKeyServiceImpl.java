package com.ishanknjr.razorpay.merchant.Service.impl;

import com.ishanknjr.razorpay.common.exceptions.ResourceNotFoundException;
import com.ishanknjr.razorpay.common.util.RandomizerUtil;
import com.ishanknjr.razorpay.merchant.DTO.request.CreateApiKeyRequest;
import com.ishanknjr.razorpay.merchant.DTO.request.Reasponse.ApiKeyCreateResponse;
import com.ishanknjr.razorpay.merchant.DTO.request.Reasponse.ApiKeyResponse;
import com.ishanknjr.razorpay.merchant.Mapper.ApiKeyMapper;
import com.ishanknjr.razorpay.merchant.Repository.ApiKeyRepository;
import com.ishanknjr.razorpay.merchant.Repository.MerchantRepository;
import com.ishanknjr.razorpay.merchant.Service.ApiKeyService;
import com.ishanknjr.razorpay.merchant.entity.APIkeys;
import com.ishanknjr.razorpay.merchant.entity.Merchant;
import jakarta.annotation.Nullable;
//import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

//import static jdk.jpackage.internal.cli.OptionValue.build;

@Service
@RequiredArgsConstructor
@Slf4j
//@org.springframework..transaction.annotation.Transactional(readOnly = true)
@Transactional(readOnly = true)
public class ApiKeyServiceImpl implements ApiKeyService {

    private final MerchantRepository merchantRepository;
    private final ApiKeyRepository apiKeyRepository;
    private final ApiKeyMapper apiKeyMapper;
    @Override
    public ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request) {
        Merchant merchant = merchantRepository.findById(merchantId)
                .orElseThrow(()-> new ResourceNotFoundException("merchant" , merchantId));

//         secure these key secrets again and store them, and we will not alow you to see the key scret here\
//        String keyId = "rzp_" + request.environment().name().toUpperCase() + " big random String ";
        String keyId = "rzp_" + request.environment().name().toLowerCase() + "  " + RandomizerUtil.randomBase64(24);

        String rawSecret =RandomizerUtil.randomBase64(24); // todorpace with encrypttt adding random
//        String keyId = "rzp_" + request.environment().name().toUpperCase() + RandomizerUtil.randomBase64(24);
//         todo encode with the bcrypt encoder

        APIkeys apiKey = APIkeys.builder()
                .merchant(merchant)
                .keyId(keyId)
                .keySecretHash(rawSecret) // stored the encrypted secret
                .environment(request.environment())
                .build();

        apiKey = apiKeyRepository.save(apiKey);

        return new ApiKeyCreateResponse(apiKey.getId() , keyId , rawSecret ,request.environment()); // returned the raw secret
    }

    @Override
    public List<ApiKeyResponse> listByMerchant(UUID merchantId) {

        return apiKeyMapper.toResponseList(apiKeyRepository.findByMerchant_Id(merchantId));

    }

    @Override
    @Transactional
    public void revoke(UUID merchantId, UUID apiKeyId) {
        APIkeys apikey = apiKeyRepository.findById(apiKeyId)
                .filter(k->k.getMerchant().getId().equals(merchantId))
                .orElseThrow(()-> new ResourceNotFoundException("ApiKey" , apiKeyId));

        apikey.setEnabled(false);
    }

    @Override
    public @Nullable  ApiKeyCreateResponse rotatekey(UUID merchantId, UUID apiKeyId) {
        APIkeys apikey = apiKeyRepository.findById(apiKeyId)
                .filter(k->k.getMerchant().getId().equals(merchantId))
                .orElseThrow(()-> new ResourceNotFoundException("ApiKey" , apiKeyId));

        if(apikey.isEnabled()){
            throw new RuntimeException("Cannot Rotate Disabled key");
        }

        String newrawSecret =RandomizerUtil.randomBase64(24);
        apikey.setPrevoiusKeySecretHash(apikey.getKeySecretHash());
        apikey.setKeySecretHash(newrawSecret);  // todorpace with encrypttt adding random
        apikey.setRotatedAt(LocalDateTime.now());
        apikey.setGracePeriodExpiresAt(LocalDateTime.now().plusHours(24));
        apikey = apiKeyRepository.save(apikey);
        return new ApiKeyCreateResponse(apikey.getId() ,apikey.getKeyId()   ,newrawSecret , apikey.getEnvironment() );
//        note raw secret dosent allow us to use the map struct here
    }


}
