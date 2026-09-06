package com.ishanknjr.razorpay.payment.Config;

import com.ishanknjr.razorpay.payment.Enums.PaymentMethod;
import com.ishanknjr.razorpay.payment.Gateway.Adaptors.CardPaymentAdaptor;
import com.ishanknjr.razorpay.payment.Gateway.Adaptors.NetBankingAdaptor;
import com.ishanknjr.razorpay.payment.Gateway.Adaptors.UPIPaymentAdaptor;
import com.ishanknjr.razorpay.payment.Gateway.PaymentAdaptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class PaymentAdaptorConfig {

    @Bean
    public Map<PaymentMethod , PaymentAdaptor> paymentAdaptorMap(){

        return Map.of(
                PaymentMethod.CARD , new CardPaymentAdaptor(),
                PaymentMethod.NETBANKING , new NetBankingAdaptor(),
                PaymentMethod.UPI , new UPIPaymentAdaptor()
        );
    }
}
