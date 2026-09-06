package com.ishanknjr.razorpay.payment.Processor;

import com.ishanknjr.razorpay.payment.Processor.DTO.PaymentProcessorRequest;
import com.ishanknjr.razorpay.payment.Processor.DTO.PaymentProcessorResponse;

public interface PaymentProcessor {
  PaymentProcessorResponse charge(PaymentProcessorRequest request);

}
