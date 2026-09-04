package com.ishanknjr.razorpay.merchant.Service.impl;

import com.ishanknjr.razorpay.common.enums.MerchantStatus;
import com.ishanknjr.razorpay.common.enums.UserRole;
import com.ishanknjr.razorpay.common.exceptions.DuplicateResourceException;
import com.ishanknjr.razorpay.merchant.DTO.request.MerchantSignupRequest;
import com.ishanknjr.razorpay.merchant.DTO.request.Reasponse.MerchantReasponse;
import com.ishanknjr.razorpay.merchant.Mapper.MerchantMapper;
import com.ishanknjr.razorpay.merchant.Repository.AppUserRepository;
import com.ishanknjr.razorpay.merchant.Repository.MerchantRepository;
import com.ishanknjr.razorpay.merchant.Service.AuthService;
import com.ishanknjr.razorpay.merchant.entity.AppUser;
import com.ishanknjr.razorpay.merchant.entity.Merchant;
//import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository appUserRepository;
    private final MerchantRepository merchantRepository;
    private final MerchantMapper merchantMapper;

    @Override
    @Transactional(readOnly = true)
    public MerchantReasponse signup(MerchantSignupRequest request) {
 
        if(merchantRepository.existsByEmail(request.email()))
        {
            throw new DuplicateResourceException("Duplicate Merchant_Email " , "Merchant with email already Exists: " + request.email() );
        }
          Merchant merchant = merchantMapper.toEntityFromSignupRequest(request);
          merchant.setStatus(MerchantStatus.PENDING_KYC);
        merchant = merchantRepository.save(merchant);

        AppUser appUser = AppUser.builder()
                .merchant(merchant)
                .email(request.email())
                .passwordHash(request.password()) // TODO: encrypt using Bcrypt
                .role(UserRole.OWNER)
                .build();
        appUserRepository.save(appUser);



        return merchantMapper.toResponse(merchant);
    }
}
