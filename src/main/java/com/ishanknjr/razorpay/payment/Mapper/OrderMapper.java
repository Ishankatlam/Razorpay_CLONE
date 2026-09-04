package com.ishanknjr.razorpay.payment.Mapper;

import com.ishanknjr.razorpay.payment.Entity.OrderRecord;
import com.ishanknjr.razorpay.payment.dto.Response.OrderResponse;
import jakarta.persistence.criteria.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {
     OrderResponse toResponseOrder(OrderRecord orderRecord);
}
