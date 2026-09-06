package com.ishanknjr.razorpay.payment.Processor.Strategy;

import com.ishanknjr.razorpay.payment.Processor.DTO.PaymentProcessorRequest;
import com.ishanknjr.razorpay.payment.Processor.DTO.PaymentProcessorResponse;
import com.ishanknjr.razorpay.payment.Processor.PaymentProcessor;

public class CardPaymentProcessor implements PaymentProcessor {

    @Override
    public PaymentProcessorResponse charge(PaymentProcessorRequest request) {
        return null;
    }

}
