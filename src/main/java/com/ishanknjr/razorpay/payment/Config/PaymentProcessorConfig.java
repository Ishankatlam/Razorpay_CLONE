package com.ishanknjr.razorpay.payment.Config;

import com.ishanknjr.razorpay.payment.Enums.PaymentMethod;
import com.ishanknjr.razorpay.payment.Processor.PaymentProcessor;
import com.ishanknjr.razorpay.payment.Processor.Strategy.CardPaymentProcessor;
import com.ishanknjr.razorpay.payment.Processor.Strategy.NetBankingProcessor;
import com.ishanknjr.razorpay.payment.Processor.Strategy.UpiPaymentProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class PaymentProcessorConfig {

    @Bean
    public Map<PaymentMethod , PaymentProcessor> paymentProcessorMap() {
     return Map.of(
             PaymentMethod.CARD , new CardPaymentProcessor(),
             PaymentMethod.NETBANKING , new NetBankingProcessor(),
             PaymentMethod.UPI , new UpiPaymentProcessor()

     );

    }
}
