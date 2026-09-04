package com.ishanknjr.razorpay.merchant.Mapper;

import com.ishanknjr.razorpay.merchant.DTO.request.MerchantSignupRequest;
import com.ishanknjr.razorpay.merchant.DTO.request.Reasponse.MerchantReasponse;
import com.ishanknjr.razorpay.merchant.entity.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MerchantMapper {
     Merchant toEntityFromSignupRequest(MerchantSignupRequest request);
      MerchantReasponse toResponse(Merchant merchant);
}
