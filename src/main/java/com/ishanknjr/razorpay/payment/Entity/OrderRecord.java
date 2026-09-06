package com.ishanknjr.razorpay.payment.Entity;

import com.ishanknjr.razorpay.common.entity.Money;
import com.ishanknjr.razorpay.payment.Enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;


@Getter
@Setter
@Table(name = "order_record" ,indexes = {@Index(name = "idx_order_id_merchant_id" , columnList = "id , merchant_id") ,
        @Index(name = "idx_order_merchant_id" , columnList = " merchant_id")
}
)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class OrderRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "merchant_id" , nullable = false)
    private UUID merchantId;

    @Embedded
    private Money amount;

    @Column(length = 100)
    private String receipt;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false , length = 100)

    @Builder.Default
    private OrderStatus orderStatus = OrderStatus.CREATED;


   @Column(nullable = false )
   @Builder.Default
    private Integer attempts =0;


   @JdbcTypeCode(SqlTypes.JSON)
   @Column(columnDefinition = "jsonb" )
    private Map<String , Object> notes ;


   @Column( name = "expires_at" , nullable = false )
    private LocalDateTime expiresAt;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;


}
