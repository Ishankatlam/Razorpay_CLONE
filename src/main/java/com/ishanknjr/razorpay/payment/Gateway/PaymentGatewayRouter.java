package com.ishanknjr.razorpay.payment.Gateway;

import com.ishanknjr.razorpay.payment.Enums.PaymentMethod;
import com.ishanknjr.razorpay.payment.Gateway.DTO.PaymentRequest;
import com.ishanknjr.razorpay.payment.Processor.DTO.PaymentResult;
import lombok.RequiredArgsConstructor;
import org.slf4j.helpers.LegacyAbstractLogger;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class PaymentGatewayRouter {

    private final Map<PaymentMethod , PaymentAdaptor> paymentAdaptorMap;
      public PaymentResult initiate(PaymentRequest request ){
       PaymentAdaptor adaptor = paymentAdaptorMap.get(request.methodDetails());
       if(adaptor == null){
           throw new IllegalArgumentException("No payment method is registered for this method : " + request.methodDetails());

       }

      return  adaptor.initiate(request);



    }
}
