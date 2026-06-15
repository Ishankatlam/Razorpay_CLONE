package com.ishanknjr.razorpay.payment;

import com.ishanknjr.razorpay.common.entity.Money;
import com.ishanknjr.razorpay.common.enums.refundstatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.hibernate.type.descriptor.jdbc.SqlTypedJdbcType;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "refund")
public class refund {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "payment_id" , nullable = false )
    private payment payment ;

    @Column(nullable = false )
    private UUID merchandId;

    @Embedded
    private Money amount ;

    @Enumerated(EnumType.STRING)
    @JoinColumn(nullable = false )
    private refundstatus status = refundstatus.PENDING;

    @Column(length = 100)
    private String bankrefrence ;

    @Column(length = 100)
    private String errorcode ;

    @Column(length = 500)
    private String errordescription ;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String , Object> notes ;

    private LocalDateTime processedat;



}
