package com.ishanknjr.razorpay.operations;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "settlement_payment")
public class settlementpayment {

    @EmbeddedId
    private settlementpaymentId Id;



    @MapsId
    @ManyToOne(fetch = FetchType.LAZY , optional = false )
    @JoinColumn(name = "settlement_id" , nullable = false )
    private settlement settlement;

}
