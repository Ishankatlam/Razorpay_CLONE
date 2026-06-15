package com.ishanknjr.razorpay.operations;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.util.UUID;

@Embeddable
public class settlementpaymentId {

    
    private UUID settlementId;

    private UUID paymentId;
}
