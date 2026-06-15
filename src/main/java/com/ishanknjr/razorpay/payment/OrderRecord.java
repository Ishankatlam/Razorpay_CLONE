package com.ishanknjr.razorpay.payment;

import com.ishanknjr.razorpay.common.entity.Money;
import com.ishanknjr.razorpay.common.enums.orderstatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "order_record")
public class OrderRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "merchant_id" , nullable = false)
    private UUID merchandId;

    @Embedded
    private Money amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false , length = 20)
    private orderstatus orderstatus= com.ishanknjr.razorpay.common.enums.orderstatus.CREATED;


   @Column(nullable = false )
    private Integer attempts;


   @JdbcTypeCode(SqlTypes.JSON)
   @Column(columnDefinition = "jsonb" )
    private Map<String , Objects> notes ;


   @Column( name = "expires_at" , nullable = false )
    private LocalDateTime expiresAt;

   
}
