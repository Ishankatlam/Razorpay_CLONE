package com.ishanknjr.razorpay.payment.Service;

import com.ishanknjr.razorpay.payment.dto.Request.CreateOrderRequest;
import com.ishanknjr.razorpay.payment.dto.Response.OrderResponse;
import com.ishanknjr.razorpay.payment.dto.Response.PaymentResponse;

import java.util.List;
import java.util.UUID;

public interface OrderService {

//    OrderResponse create(CreateOrderRequest request);

    OrderResponse create(UUID merchantId, CreateOrderRequest request);

    OrderResponse getById(UUID merchantId, UUID orderId);

    OrderResponse cancel(UUID merchantId, UUID orderId);

     List<PaymentResponse> listPayments(UUID merchantId , UUID orderId);
}