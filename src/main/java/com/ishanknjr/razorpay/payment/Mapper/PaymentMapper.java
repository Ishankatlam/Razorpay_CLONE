package com.ishanknjr.razorpay.payment.Mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.ishanknjr.razorpay.payment.Entity.payment;
import com.ishanknjr.razorpay.payment.dto.Response.PaymentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {
    @Mapping(target = "orderId" , source = "order.id")
    PaymentResponse toResponse(payment payment);

    @Mapping(target = "orderId" , source = "order.id")
    List<PaymentResponse> toResponseList(List<payment> paymentList);

}
