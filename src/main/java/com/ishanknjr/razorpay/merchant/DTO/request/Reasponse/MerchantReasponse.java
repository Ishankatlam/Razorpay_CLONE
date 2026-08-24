package com.ishanknjr.razorpay.merchant.DTO.request.Reasponse;

import com.ishanknjr.razorpay.common.enums.BusinessType;
import com.ishanknjr.razorpay.common.enums.MerchantStatus;
import lombok.Data;

import java.util.UUID;


public record MerchantReasponse(

        UUID id,
        String name ,
        String email,
        String businessName,
        BusinessType businessType,
        MerchantStatus merchantStatus
) {
}
