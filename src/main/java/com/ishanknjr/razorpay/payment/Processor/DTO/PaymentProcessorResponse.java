package com.ishanknjr.razorpay.payment.Processor.DTO;

public sealed interface PaymentProcessorResponse permits PaymentProcessorResponse.Pending  ,
PaymentProcessorResponse.Success , PaymentProcessorResponse.Failure{
    record  Pending(String processerRef) implements PaymentProcessorResponse {}

    record Success(String processorRef , String bankReference) implements PaymentProcessorResponse{}

    record Failure(String errorCode , String errorDescription) implements PaymentProcessorResponse{}

// concept sealed class this class only be extended when i will permit impl of sealed classes
// mark PaymentProcessorResponse permits PaymentProcessorResponse.Pending  , PaymentProcessorResponse.Success , PaymentProcessorResponse.Failure
}
