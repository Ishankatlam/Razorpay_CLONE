package com.ishanknjr.razorpay.payment.Service;

import com.ishanknjr.razorpay.payment.dto.Request.CreateOrderRequest;
import com.ishanknjr.razorpay.payment.dto.Response.OrderResponse;

import java.util.UUID;

public interface OrderService {

//    OrderResponse create(CreateOrderRequest request);

    OrderResponse create(UUID merchantId, CreateOrderRequest request);
}