package com.ishanknjr.razorpay.payment.Mapper;

import com.ishanknjr.razorpay.payment.Entity.Payment;
import com.ishanknjr.razorpay.payment.dto.Response.PaymentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {
    @Mapping(target = "orderId" , source = "order.id")
    PaymentResponse toResponse(Payment payment);

    @Mapping(target = "orderId" , source = "order.id")
    List<PaymentResponse> toResponseList(List<Payment> paymentList);

}
