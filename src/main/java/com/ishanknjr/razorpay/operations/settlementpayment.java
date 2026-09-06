package com.ishanknjr.razorpay.operations;

import com.ishanknjr.razorpay.common.entity.BaseEntity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "settlement_payment")
public class settlementpayment extends BaseEntity{

    @EmbeddedId
    private settlementpaymentId Id;

    @MapsId("settlementId")
    @ManyToOne(fetch = FetchType.LAZY , optional = false )
    @JoinColumn(name = "settlement_id" , nullable = false )
    private settlement settlement;

}
