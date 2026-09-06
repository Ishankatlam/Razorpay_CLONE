package com.ishanknjr.razorpay.payment.Gateway;

import com.ishanknjr.razorpay.payment.Gateway.DTO.PaymentRequest;
import com.ishanknjr.razorpay.payment.Processor.DTO.PaymentResult;

public interface PaymentAdaptor {
    PaymentResult initiate(PaymentRequest request);
}
