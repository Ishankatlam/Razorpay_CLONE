package com.ishanknjr.razorpay.payment.Processor.DTO;

public sealed interface PaymentResult permits PaymentResult.Pending , PaymentResult.Failure {

    record Pending(String registrationRef) implements PaymentResult{}

    record Failure(String errorCode , String errorDescription) implements PaymentResult{}

//    record
}
