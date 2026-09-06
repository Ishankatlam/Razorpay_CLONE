package com.ishanknjr.razorpay.payment.Service;

import com.ishanknjr.razorpay.payment.dto.Request.PaymentInitRequestDTO;
import com.ishanknjr.razorpay.payment.dto.Response.PaymentResponse;

import java.util.UUID;

public interface PaymentService {
    PaymentResponse initiate(UUID merchanId , PaymentInitRequestDTO request);
}
