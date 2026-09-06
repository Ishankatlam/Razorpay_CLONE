package com.ishanknjr.razorpay.operations;

import com.ishanknjr.razorpay.common.entity.BaseEntity;
import com.ishanknjr.razorpay.common.entity.Money;
import com.ishanknjr.razorpay.common.enums.settlementstatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "settlement")
public class settlement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column( nullable = false )
    private UUID merchantId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "amountUnits",
                    column = @Column(name = "gross_amount_units", nullable = false)
            ),
            @AttributeOverride(
                    name = "currency",
                    column = @Column(name = "gross_amount_currency", nullable = false)
            )
    })
    private Money grossamount ;



    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "amountUnits",
                    column = @Column(name = "refund_amount_units", nullable = false)
            ),
            @AttributeOverride(
                    name = "currency",
                    column = @Column(name = "refund_amount_currency", nullable = false)
            )
    })
    private Money refundamount ;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "amountUnits",
                    column = @Column(name = "fee_amount_units", nullable = false)
            ),
            @AttributeOverride(
                    name = "currency",
                    column = @Column(name = "fee_amount_currency", nullable = false)
            )
    })
    private Money feeamount ;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "amountUnits",
                    column = @Column(name = "gst_amount_units", nullable = false)
            ),
            @AttributeOverride(
                    name = "currency",
                    column = @Column(name = "gst_amount_currency", nullable = false)
            )
    })
    private Money gstamount ;

    @AttributeOverrides({
            @AttributeOverride(
                    name = "amountUnits",
                    column = @Column(name = "net_amount_units", nullable = false)
            ),
            @AttributeOverride(
                    name = "currency",
                    column = @Column(name = "net_amount_currency", nullable = false)
            )
    })
    private Money netamount ;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false , length = 20)
    private settlementstatus status ;

    @Column(nullable = false , length = 50)
    private String bankrefrence ;



    private LocalDateTime processedat;

}
