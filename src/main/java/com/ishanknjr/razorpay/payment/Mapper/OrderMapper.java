package com.ishanknjr.razorpay.payment.Mapper;

import com.ishanknjr.razorpay.payment.Entity.OrderRecord;
import com.ishanknjr.razorpay.payment.dto.Response.OrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
     OrderResponse toResponseOrder(OrderRecord orderRecord);
}
