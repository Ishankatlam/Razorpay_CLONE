package com.ishanknjr.razorpay.merchant.Mapper;

import com.ishanknjr.razorpay.merchant.DTO.request.Reasponse.ApiKeyCreateResponse;
import com.ishanknjr.razorpay.merchant.DTO.request.Reasponse.ApiKeyResponse;
import com.ishanknjr.razorpay.merchant.entity.APIkeys;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApiKeyMapper {
     ApiKeyCreateResponse toCreateresponse(APIkeys apikey);
     List<ApiKeyResponse> toResponseList(List<APIkeys> apikeys);
//
}
