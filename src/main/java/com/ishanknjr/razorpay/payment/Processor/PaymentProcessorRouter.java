package com.ishanknjr.razorpay.payment.Processor;

import com.ishanknjr.razorpay.payment.Enums.PaymentMethod;
import com.ishanknjr.razorpay.payment.Processor.DTO.PaymentProcessorRequest;
import com.ishanknjr.razorpay.payment.Processor.DTO.PaymentProcessorResponse;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentProcessorRouter {
    private Map<PaymentMethod , PaymentProcessor> paymentProcessors;


       public PaymentProcessorResponse charge(PaymentProcessorRequest request)
        {
            PaymentProcessor processor = paymentProcessors.get(request.method());
            if(processor == null)
            {
                throw new IllegalArgumentException("No Payment processor registered for method" + request.method());
            }

            return processor.charge(request);
        }


}
