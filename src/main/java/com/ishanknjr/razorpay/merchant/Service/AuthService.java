package com.ishanknjr.razorpay.merchant.Service;

import com.ishanknjr.razorpay.merchant.DTO.request.MerchantSignupRequest;
import com.ishanknjr.razorpay.merchant.DTO.request.Reasponse.MerchantReasponse;
import jakarta.validation.Valid;

public interface AuthService {

    MerchantReasponse signup( MerchantSignupRequest request);
}
